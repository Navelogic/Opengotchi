package br.com.opengotchi.api.Config.Gotchi;


import br.com.opengotchi.api.Service.Model.Gotchi.Alimento.Alimentos.Maca;
import br.com.opengotchi.api.Service.Model.Gotchi.Alimento.Comida;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.Causas.FaltaEnergia;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.Causas.FomeExtrema;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.CondicaoMorte;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class GotchiConfig {
    @Bean
    public List<CondicaoMorte> condicaoMortes(){
        return Arrays.asList(
                new FaltaEnergia(),
                new FomeExtrema()
        );
    }

    @Bean
    public Map<String, Comida> comidasDisponiveis() {
        Map<String, Comida> comidas = new HashMap<>();
        comidas.put("Maça", new Maca());
        return comidas;
    }

}
