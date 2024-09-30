package br.com.opengotchi.api.Util.Model;

import br.com.opengotchi.api.Util.GeneroList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personalidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroList genero;
}
