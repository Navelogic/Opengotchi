package br.com.opengotchi.api.Service.Model.Gotchi.Descansar;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Util.EstagioVidaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class DescansarService {

    private final GotchiRepository gotchiRepository;

    @Autowired
    public DescansarService(GotchiRepository gotchiRepository) {
        this.gotchiRepository = gotchiRepository;
    }

    @Transactional
    public void dormir(Gotchi gotchi) {
        gotchi.setDormindo(true);
        gotchi.setUltimo_sono(Instant.now());
        gotchi.setVezes_sem_dormir(0);
        gotchiRepository.save(gotchi);
    }

    @Transactional
    public void acordar(Gotchi gotchi) {
        gotchi.setDormindo(false);
        gotchi.setUltimo_despertar(Instant.now());
        gotchiRepository.save(gotchi);
    }


    @Scheduled(fixedRate = 20000)
    @Transactional
    public void gerenciarEnergia() {
        List<Gotchi> gotchis = gotchiRepository.findAll();
        int energiaMaxima = 100;
        int taxaRecuperacaoPorHora = 5;
        int taxaReducaoPorHora = 2;
        int taxaAumentadaParaIdoso = 5;
        int energiaMinimaParaDormir = 20;
        int limiteVezesSemDormir = 3;

        for (Gotchi gotchi : gotchis) {
            if (gotchi.getEstagio_vida() == EstagioVidaList.MORTO || gotchi.getEstagio_vida() == EstagioVidaList.OVO)
                continue;

            Instant agora = Instant.now();
            if (gotchi.getUltimo_sono() == null) {
                gotchi.setUltimo_sono(agora);
            } else {
                long horasDesdeUltimoSono = Duration.between(gotchi.getUltimo_sono(), agora).toHours();
                int ajusteEnergia = (int) (horasDesdeUltimoSono * (gotchi.isDormindo() ? taxaRecuperacaoPorHora :
                        (gotchi.getEstagio_vida() == EstagioVidaList.IDOSO ? taxaReducaoPorHora + taxaAumentadaParaIdoso : taxaReducaoPorHora)));

                gotchi.setEnergia(Math.min(Math.max(gotchi.getEnergia() + (gotchi.isDormindo() ? ajusteEnergia : -ajusteEnergia), 0), energiaMaxima));

                if (gotchi.isDormindo()) {
                    gotchi.setUltimo_sono(agora);
                    if (gotchi.getEnergia() >= energiaMaxima) {
                        acordar(gotchi);
                    }
                } else if (gotchi.getEnergia() <= energiaMinimaParaDormir) {
                    dormir(gotchi);
                    gotchi.setVezes_sem_dormir(gotchi.getVezes_sem_dormir() + 1);

                    if (gotchi.getVezes_sem_dormir() >= limiteVezesSemDormir) {
                        gotchi.setEstagio_vida(EstagioVidaList.MORTO);
                        gotchi.setHora_morte(agora);
                        gotchi.setCausa_morte("Falta de descanso");
                    }
                }
            }
            gotchiRepository.save(gotchi);
        }
    }
}