package br.com.opengotchi.api.Service.Model.Gotchi;

import br.com.opengotchi.api.Config.Exception.Gotchi.GotchiNaoEncontradoExeption;
import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Repository.CorRepository;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Repository.PersonalidadeRepository;
import br.com.opengotchi.api.Service.Model.Gotchi.Alimento.AlimentoService;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.MorteService;
import br.com.opengotchi.api.Util.EstagioVidaList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class GotchiService {

    private final MorteService morteService;
    private final AlimentoService alimentoService;
    private final CorRepository corRepository;
    private final GotchiRepository gotchiRepository;
    private final PersonalidadeRepository personalidadeRepository;

    private static final Logger logger = LoggerFactory.getLogger(GotchiService.class);

    @Autowired
    public GotchiService(MorteService morteService, AlimentoService alimentoService, GotchiRepository gotchiRepository, CorRepository corRepository, PersonalidadeRepository personalidadeRepository) {
        this.morteService = morteService;
        this.alimentoService = alimentoService;
        this.gotchiRepository = gotchiRepository;
        this.corRepository = corRepository;
        this.personalidadeRepository = personalidadeRepository;
    }

    @Transactional(readOnly = true)
    public List<Gotchi> findAll() {
        return gotchiRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Gotchi findById(Long id) {
        return gotchiRepository.findById(id).orElseThrow(() -> new GotchiNaoEncontradoExeption("Gotchi não encontrado com o id: " + id));
    }

    @Transactional
    public Gotchi save(Gotchi gotchi, String codigo) {

        if (gotchi.getNome() == null || gotchi.getGenero() == null){
            throw new RuntimeException("Gotchi inválido");
        }

        if (codigo.equals("4002")){
            // Selecionando estadio de vida aleatório da lista Enum EstagioVidaList
            gotchi.setEstagio_vida(EstagioVidaList.values()[(int) (Math.random() * EstagioVidaList.values().length)]);

            // Selecionando cores aleatórias a partir de Query Method
            gotchi.setCor_pele(corRepository.getRandom());
            gotchi.setCor_olhos(corRepository.getRandom());
            gotchi.setCor_cabelo(corRepository.getRandom());

            // Selecionando personalidade aleatória a partir de Query Method e Genero da personalidade seja igual ao genero do Gotchi
            do {
                gotchi.setPersonalidade(personalidadeRepository.getRandom());
            } while (gotchi.getGenero() != gotchi.getPersonalidade().getGenero());
        }
        gotchiRepository.save(gotchi);
        return gotchi;
    }


    @Transactional
    public void alimentar(Long id, String nomeComida) {
        alimentoService.alimentar(id, nomeComida);
    }

    @Scheduled(fixedRate = 20000)
    @Transactional
    public void diminuirEnergia() {
        List<Gotchi> gotchis = gotchiRepository.findAll();
        int horasParaDormir = 8;
        int energiaMaxima = 100;

        for (Gotchi gotchi : gotchis) {
            if (gotchi.getEstagio_vida() == EstagioVidaList.MORTO) {
                continue;
            }

            Instant agora = Instant.now();

            if (gotchi.getUltimo_sono() == null) {
                gotchi.setUltimo_sono(agora);
                gotchi.setEnergia(energiaMaxima);
                gotchiRepository.save(gotchi);
                continue;
            }

            long horasDesdeUltimoSono = Duration.between(gotchi.getUltimo_sono(), agora).toHours();
            if (gotchi.isDormindo()) {
                int aumentoDeEnergia = (energiaMaxima / horasParaDormir) * (int) horasDesdeUltimoSono;
                gotchi.setEnergia(Math.min(gotchi.getEnergia() + aumentoDeEnergia, energiaMaxima));
            } else {
                int diminuicaoDeEnergia = (energiaMaxima / 24) * (int) horasDesdeUltimoSono;
                gotchi.setEnergia(Math.max(gotchi.getEnergia() - diminuicaoDeEnergia, 0));
            }

            gotchi.setUltimo_sono(agora);
            gotchiRepository.save(gotchi);
        }
    }

    @Scheduled(fixedRate = 30000)
    @Transactional
    public void verificarMorte() {
        List<Gotchi> gotchis = gotchiRepository.findAll();

        for (Gotchi gotchi : gotchis) {
            if (gotchi.getEstagio_vida() != EstagioVidaList.MORTO) {
                morteService.verificarMorte();
            }
        }
    }

}
