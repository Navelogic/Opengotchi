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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_humano")
public class Humano implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    private Instant lastLogin;
    private Instant lastUpdate;
    private Instant createdAt;

    public void nasceu(){
        this.createdAt = Instant.now();
        this.lastLogin = Instant.now();
        this.lastUpdate = Instant.now();
    }
}
