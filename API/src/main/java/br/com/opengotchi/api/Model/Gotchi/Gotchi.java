package br.com.opengotchi.api.Model.Gotchi;

import br.com.opengotchi.api.Util.EstagioVidaList;
import br.com.opengotchi.api.Util.GeneroList;
import br.com.opengotchi.api.Util.Model.Cor;
import br.com.opengotchi.api.Util.Model.Personalidade;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "gotchis")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gotchi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identificação do Gotchi
    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroList genero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstagioVidaList estagio_vida = EstagioVidaList.OVO;

    @ManyToOne
    @JoinColumn(name = "cor_pele_id", nullable = false)
    private Cor cor_pele;

    @ManyToOne
    @JoinColumn(name = "cor_olhos_id", nullable = false)
    private Cor cor_olhos;

    @ManyToOne
    @JoinColumn(name = "cor_cabelo_id", nullable = false)
    private Cor cor_cabelo;

    @ManyToOne
    @JoinColumn(name = "personalidade_id", nullable = false)
    private Personalidade personalidade;

    // Atributos de status do Gotchi
    private Integer fome = 0;
    private Instant ultima_refeicao;

    private Integer energia = 100;
    private Instant ultimo_sono;

    private Instant hora_morte;
    private String causa_morte;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant criado_em;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant ultima_atualizacao;

    private boolean dormindo = false;
}
