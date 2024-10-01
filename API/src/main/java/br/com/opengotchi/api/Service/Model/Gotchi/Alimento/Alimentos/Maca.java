package br.com.opengotchi.api.Service.Model.Gotchi.Alimento.Alimentos;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Service.Model.Gotchi.Alimento.Comida;

public class Maca implements Comida {

    @Override
    public void alimentar(Gotchi gotchi) {
        int novaFome = Math.max(gotchi.getFome() - getValorNutricional(), 0);
        gotchi.setFome(novaFome);
    }

    @Override
    public String getNome() {
        return "Maça";
    }

    @Override
    public int getValorNutricional() {
        return 5;
    }
}
