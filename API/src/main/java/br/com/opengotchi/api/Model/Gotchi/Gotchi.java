package br.com.opengotchi.api.Model.Gotchi;

import br.com.opengotchi.api.Model.Humano;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_gotchis")
public class Gotchi implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    private String pronome;
    private String humor = "Feliz";
    private String doenca;
    @Column(nullable = false)
    private String tipoEspecie = "Gotchi";
    private String corPrimaria;
    private String corSecundaria;
    private String corTerciaria;
    private String aniversarioString;
    private String idade;

    private Integer vidas = 10;
    private Integer fome = 100;
    private Integer saude = 100;
    private Integer higiene = 100;
    private Integer energia = 100;
    private Integer banheiro = 100;
    private Integer disciplina = 100;
    private Integer atencao = 100;

    @Column(nullable = false)
    private Instant ultimaAlimentacao;
    @Column(nullable = false)
    private Instant ultimoBanho;
    @Column(nullable = false)
    private Instant ultimoSono;
    @Column(nullable = false)
    private Instant ultimaAtualizacao;
    @Column(nullable = false)
    private Instant nasceuEm;
    private Instant morreuEm;

    private Boolean estaMorto = false;
    private Boolean estaDoente= false;
    private Boolean estaDormindo = false;
    private Boolean estaFaminto = false;
    private Boolean estaSujo = false;
    private Boolean estaImuneDoencas = false;
    private Boolean estaImortal = false;
    private Boolean gerandoGotchi = false;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "humano_id")
    private Humano humano;

    // Primarios
    public void nascer(){
        this.nasceuEm = Instant.now();
        this.ultimaAlimentacao = Instant.now();
        this.ultimoBanho = Instant.now();
        this.ultimoSono = Instant.now();
        this.ultimaAtualizacao = Instant.now();
    }

    public void morrer(){
        this.morreuEm = Instant.now();
        this.estaMorto = true;
    }
}
