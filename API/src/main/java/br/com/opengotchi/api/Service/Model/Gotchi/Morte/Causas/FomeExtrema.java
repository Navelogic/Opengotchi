package br.com.opengotchi.api.Service.Model.Gotchi.Morte.Causas;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.CondicaoMorte;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FomeExtrema implements CondicaoMorte {
    private final Random random = new Random();

    @Override
    public boolean verificar(Gotchi gotchi) {
        if (gotchi.getFome() >= 80) {
            double probabilidadeMorte = calcularProbabilidadeMorte(gotchi.getFome());
            return random.nextDouble() < probabilidadeMorte;
        }
        return false;
    }

    @Override
    public String causa() {
        return "Morreu de fome.";
    }

    private double calcularProbabilidadeMorte(int fome) {
        return 0.4 * fome / 100.0;
    }
}
