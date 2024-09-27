package br.com.opengotchi.api.Model.Gotchi;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Gotchi")
@Table(name = "gotchis")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Gotchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
}
