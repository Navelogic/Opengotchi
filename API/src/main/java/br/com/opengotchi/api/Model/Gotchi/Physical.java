package br.com.opengotchi.api.Model.Gotchi;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Embeddable
public class Physical {

    // Songs of Syx - Inspired

    @Min(value = 0, message = "Weight cannot be negative")
    private int weight = 10; // Peso

    @Min(value = 0, message = "Stamina cannot be negative")
    private int stamina = 10; // Energia

    @Min(value = 0, message = "Speed cannot be negative")
    private int speed = 10; // Velocidade

    @Min(value = 0, message = "Acceleration cannot be negative")
    private int acceleration = 10; // Aceleração

    @Min(value = 0, message = "Health cannot be negative")
    private int maxHealth = 100; // Vida Máxima

    @Min(value = 0, message = "Health cannot be negative")
    private int currentHealth = 100; // Vida Atual

    @Min(value = 0, message = "Heat resistance cannot be negative")
    private int heatResistance = 10; // Resistência ao Calor

    @Min(value = 0, message = "Cold resistance cannot be negative")
    private int coldResistance = 10; // Resistência ao Frio

    @Min(value = 0, message = "Strength cannot be negative")
    private int strength = 10; // Força

    @Min(value = 0, message = "Agility cannot be negative")
    private int agility = 10; // Agilidade

    @Min(value = 0, message = "Endurance cannot be negative")
    private int endurance = 10; // Resistência

    @Override
    public String toString() {
        return String.format(
                "Physical{weight=%d, stamina=%d, speed=%d, acceleration=%d, maxHealth=%d, currentHealth=%d, heatResistance=%d, coldResistance=%d, strength=%d, agility=%d, endurance=%d}",
                weight, stamina, speed, acceleration, maxHealth, currentHealth, heatResistance, coldResistance, strength, agility, endurance
        );
    }
}
