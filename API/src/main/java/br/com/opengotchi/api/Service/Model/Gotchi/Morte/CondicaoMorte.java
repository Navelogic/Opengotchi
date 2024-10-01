package br.com.opengotchi.api.Service.Model.Gotchi.Morte;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import org.springframework.stereotype.Component;

@Component
public interface CondicaoMorte {
    boolean verificar(Gotchi gotchi);
    String causa();
}
