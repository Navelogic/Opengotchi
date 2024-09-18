package br.com.opengotchi.api.Service;

import br.com.opengotchi.api.Entitie.Gotchi.Gotchi;
import br.com.opengotchi.api.Entitie.Humano;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Repository.HumanoRepository;
import br.com.opengotchi.api.Util.API_URLs;
import br.com.opengotchi.api.Util.ConsumoAPI;
import br.com.opengotchi.api.Util.Model.DadosDigimon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import java.util.UUID;

@Service
public class GotchiService {

    private static final Logger log = LoggerFactory.getLogger(GotchiService.class);
    @Autowired
    private GotchiRepository gotchiRepository;

    @Autowired
    private HumanoRepository humanoRepository;

    public Long quantidadeDeGotchis(){
        log.info("Quantidade de gotchis: {}", gotchiRepository.count());
        return gotchiRepository.count();
    }

    public List<Gotchi> findAll(){
        return gotchiRepository.findAll();
    }

    public Gotchi findById(UUID id){
        return gotchiRepository.findById(id).orElse(null);
    }

    @Transactional
    public Gotchi criarGotchi(Gotchi gotchi, UUID humanoID){
        gotchi.nascer();
        gotchi.setHumano(humanoRepository.findById(humanoID).orElse(null));
        humanoRepository.findById(humanoID).ifPresent(humano -> {
            humano.getGotchis().add(gotchi);
            humanoRepository.save(humano);
        });
        log.info("Gotchi criado: {}", gotchi.getNome());
        return gotchiRepository.save(gotchi);
    }
}
