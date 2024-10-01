package br.com.opengotchi.api.Service.Model.Gotchi.Alimento;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Util.EstagioVidaList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AlimentoService {
    private final GotchiRepository gotchiRepository;
    private final Map<String, Comida> comidasDisponiveis;

    @Autowired
    public AlimentoService(GotchiRepository gotchiRepository, Map<String, Comida> comidasDisponiveis) {
        this.gotchiRepository = gotchiRepository;
        this.comidasDisponiveis = comidasDisponiveis;
    }

    @Transactional
    public void alimentar(Long id, String nomeComida) {
        Gotchi gotchi = gotchiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gotchi não encontrado"));

        Comida comida = comidasDisponiveis.get(nomeComida);
        if (comida == null) {
            throw new RuntimeException("Comida não encontrada");
        }

        comida.alimentar(gotchi);
        gotchi.setUltima_refeicao(Instant.now());
        gotchiRepository.save(gotchi);
    }

    @Scheduled(fixedRate = 15000)
    @Transactional
    public void aumentarFome() {
        log.info("Aumentando fome dos gotchis");
        List<Gotchi> gotchis = gotchiRepository.findAll();
        int numeroDeRefeicoes = 3;
        int fomeMaxima = 100;

        for (Gotchi gotchi : gotchis) {
            if (gotchi.getEstagio_vida() == EstagioVidaList.MORTO || gotchi.getEstagio_vida() == EstagioVidaList.OVO) {
                continue;
            }

            Instant agora = Instant.now();

            if (gotchi.getUltima_refeicao() == null) {
                inicializarRefeicao(gotchi, agora);
                continue;
            }

            processarAumentoDeFome(gotchi, agora, numeroDeRefeicoes, fomeMaxima);
        }
    }

    private void inicializarRefeicao(Gotchi gotchi, Instant agora) {
        gotchi.setUltima_refeicao(agora);
        gotchi.setFome(0);
        gotchiRepository.save(gotchi);
    }

    private void processarAumentoDeFome(Gotchi gotchi, Instant agora, int numeroDeRefeicoes, int fomeMaxima) {
        long horasDesdeUltimaRefeicao = Duration.between(gotchi.getUltima_refeicao(), agora).toHours();
        long refeicoesPerdidas = horasDesdeUltimaRefeicao / (24 / numeroDeRefeicoes);

        if (refeicoesPerdidas > 0) {
            int aumentoDeFome = (fomeMaxima / numeroDeRefeicoes) * (int) refeicoesPerdidas;
            gotchi.setFome(Math.min(gotchi.getFome() + aumentoDeFome, fomeMaxima));
            gotchi.setUltima_refeicao(agora);
            gotchiRepository.save(gotchi);
        }
    }
}