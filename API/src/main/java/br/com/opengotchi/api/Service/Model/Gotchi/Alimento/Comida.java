package br.com.opengotchi.api.Service.Model.Gotchi.Alimento;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import org.springframework.stereotype.Component;

@Component
public interface Comida {
    void alimentar(Gotchi gotchi);
    String getNome();
    int getValorNutricional();
}
