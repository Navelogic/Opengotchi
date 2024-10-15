package br.com.opengotchi.api.Service.Model.Gotchi;

import br.com.opengotchi.api.Config.Exception.Gotchi.GotchiNaoEncontradoExeption;
import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Repository.CorRepository;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Repository.PersonalidadeRepository;
import br.com.opengotchi.api.Service.Model.Gotchi.Alimento.AlimentoService;
import br.com.opengotchi.api.Service.Model.Gotchi.Descansar.DescansarService;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.MorteService;
import br.com.opengotchi.api.Util.EstagioVidaList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GotchiService {

    private final MorteService morteService;
    private final AlimentoService alimentoService;
    private final CorRepository corRepository;
    private final GotchiRepository gotchiRepository;
    private final PersonalidadeRepository personalidadeRepository;

    private static final Logger logger = LoggerFactory.getLogger(GotchiService.class);
    private final DescansarService descansarService;

    @Autowired
    public GotchiService(MorteService morteService, AlimentoService alimentoService, GotchiRepository gotchiRepository, CorRepository corRepository, PersonalidadeRepository personalidadeRepository, DescansarService descansarService) {
        this.morteService = morteService;
        this.alimentoService = alimentoService;
        this.gotchiRepository = gotchiRepository;
        this.corRepository = corRepository;
        this.personalidadeRepository = personalidadeRepository;
        this.descansarService = descansarService;
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
            gotchi.setEstagio_vida(EstagioVidaList.values()[(int) (Math.random() * EstagioVidaList.values().length)]);
            gotchi.setCor_pele(corRepository.getRandom());
            gotchi.setCor_olhos(corRepository.getRandom());
            gotchi.setCor_cabelo(corRepository.getRandom());

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

    @Transactional
    public void dormir(Long id){
        descansarService.dormir(findById(id));
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
