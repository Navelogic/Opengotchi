package br.com.opengotchi.api.Service.Model.Gotchi.Morte;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Util.EstagioVidaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class MorteService {
    private final GotchiRepository gotchiRepository;
    private final List<CondicaoMorte> condicaoMorte;

    @Autowired
    public MorteService(GotchiRepository gotchiRepository, List<CondicaoMorte> condicaoMorte) {
        this.gotchiRepository = gotchiRepository;
        this.condicaoMorte = condicaoMorte;
    }

    @Transactional
    public void verificarMorte(){
        List<Gotchi> gotchis = gotchiRepository.findAll();

        for (Gotchi gotchi : gotchis) {
            for (CondicaoMorte condition : condicaoMorte) {
                if (condition.verificar(gotchi)) {
                    matarGotchi(gotchi, condition.causa());
                    break;
                }
            }
        }
    }

    @Transactional
    public void matarGotchi(Gotchi gotchi, String causaMorte) {
        gotchi.setEstagio_vida(EstagioVidaList.MORTO);
        gotchi.setHora_morte(Instant.now());
        gotchi.setCausa_morte(causaMorte);
        gotchiRepository.save(gotchi);
    }
}