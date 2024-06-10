package br.com.opengotchi.api.Service;

import br.com.opengotchi.api.Entitie.Gotchi;
import br.com.opengotchi.api.Repository.GotchiRepository;
import br.com.opengotchi.api.Util.API_URLs;
import br.com.opengotchi.api.Util.ConsumoAPI;
import br.com.opengotchi.api.Util.Model.DadosDigimon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GotchiService {
    @Autowired
    private GotchiRepository gotchiRepository;

    /* Criando um Gotchi
    * */
    public Gotchi create(Gotchi gotchi){
        return gotchiRepository.save(gotchi);
    }

    public List<Gotchi> findAll(){
        return gotchiRepository.findAll();
    }

    public Long count(){
        return gotchiRepository.count();
    }

    public void delete(){
        gotchiRepository.deleteAll();
    }

    // API - Digimon
    public String apiTestDigimon(){
        var consumoAPI = new ConsumoAPI();
        return consumoAPI.obterDadosAPI(API_URLs.DIGIMON + "1");
    }

    public String findDigimonById(String id){
        var consumoAPI = new ConsumoAPI();
        return consumoAPI.obterDadosAPI(API_URLs.DIGIMON + id);
    }

    public String findDigimonByName(String nome){
        var consumoAPI = new ConsumoAPI();
        return consumoAPI.obterDadosAPI(API_URLs.DIGIMON + nome);
    }

    public List<DadosDigimon> findAllDigimon() {
        var consumoAPI = new ConsumoAPI();
        var objectMapper = new ObjectMapper();
        return IntStream.rangeClosed(1, 1460)
                .parallel()
                .mapToObj(i -> {
                    String jsonResponse = consumoAPI.obterDadosAPI(API_URLs.DIGIMON + i);
                    try {
                        return objectMapper.readValue(jsonResponse, DadosDigimon.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    // API - Pokemon
    public String apiTestPokemon(){
        var consumoAPI = new ConsumoAPI();
        return consumoAPI.obterDadosAPI(API_URLs.POKEMON + "1");
    }
}
