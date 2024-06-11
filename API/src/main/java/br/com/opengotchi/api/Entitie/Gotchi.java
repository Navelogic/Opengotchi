package br.com.opengotchi.api.Entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_gotchi")
public class Gotchi implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String pronoun;
    private String mood = "Feliz";
    private String illness;
    private String species = "Gotchi";
    private String color;

    private Integer age = 1;
    private Integer helth = 100;
    private Integer hearts = 10;

    private Instant lastFeed;
    private Instant lastClean;
    private Instant lastSleep;
    private Instant lastMedicine;
    private Instant lastUpdate;

    private Instant bornAt;
    private Instant deadAt;

    private Boolean isDead = false;
    private Boolean isSick= false;
    private Boolean isSleeping = false;
    private Boolean isHungry = false;
    private Boolean isDirty = false;

    private Boolean isImmune = false;
    private Boolean isImortal = false;

    private Boolean isPregnant = false;
}
