package br.com.opengotchi.api.Model.Gotchi;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Needs {
    private int hunger; // Fome
    private int comfort; // Conforto
    private int hygiene; // Higiene
    private int bladder; // Bexiga
    private int energy; // Energia // Stamina
    private int fun; // Diversão
    private int social; // Social
    private int room; // Ambiente
}
