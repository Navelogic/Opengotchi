package br.com.opengotchi.api.Entitie;

import br.com.opengotchi.api.Entitie.Gotchi.Gotchi;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_humanos")
public class Humano implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;


    private Instant ultimaEntrada;
    private Instant ultimaAtualizacao;
    @Column(nullable = false)
    private Instant criadoEm;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "humano", fetch = FetchType.LAZY)
    private Set<Gotchi> gotchis = new HashSet<>();

    public void nascer(){
        this.criadoEm = Instant.now();
        this.ultimaEntrada = Instant.now();
        this.ultimaAtualizacao = Instant.now();
    }
}
