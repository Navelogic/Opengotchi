package br.com.opengotchi.api.Model.Gotchi;

import br.com.opengotchi.api.Util.List.GenderList;
import br.com.opengotchi.api.Util.List.LifeStageList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "gotchis")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gotchi {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderList gender;

    @NotNull(message = "Life stage is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LifeStageList lifeStage = LifeStageList.EGG;

    @Embedded
    private Physical physical;

    @Embedded
    private Needs needs;

    @Embedded
    private Skills skills;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant lastUpdate;

    @Column(nullable = false)
    private Boolean sleeping = false;
}
