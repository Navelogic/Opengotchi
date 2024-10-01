package br.com.opengotchi.api.Service.Model.Gotchi.Morte.Causas;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Service.Model.Gotchi.Morte.CondicaoMorte;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FaltaEnergia implements CondicaoMorte {
    private final Random random = new Random();

    @Override
    public boolean verificar(Gotchi gotchi) {
        if (gotchi.getEnergia() <= 20) {
            double probabilidadeMorte = calcularProbabilidadeMorte(gotchi.getEnergia());
            return random.nextDouble() < probabilidadeMorte;
        }
        return false;
    }

    @Override
    public String causa() {
        return "Morreu por falta de descanso.";
    }

    private double calcularProbabilidadeMorte(int energia) {
        return 0.6 * (100 - energia) / 100.0;
    }
}
