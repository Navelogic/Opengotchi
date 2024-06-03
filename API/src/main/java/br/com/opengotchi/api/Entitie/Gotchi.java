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
    private String mood;
    private String illness;
    private String species;
    private String color;

    private Integer age;
    private Integer helth;
    private Integer hearts = 10;

    private Instant lastFeed;
    private Instant lastClean;
    private Instant lastSleep;
    private Instant lastMedicine;
    private Instant lastUpdate;

    private Instant bornAt;
    private Instant deadAt;

    private Boolean isDead;
    private Boolean isSick;
    private Boolean isSleeping;
    private Boolean isHungry;
    private Boolean isDirty;

    private Boolean isImmune;
    private Boolean isImortal;

    private Boolean isPregnant;
}
