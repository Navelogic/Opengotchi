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

    public void nascer(){
        this.createdAt = Instant.now();
        this.lastLogin = Instant.now();
        this.lastUpdate = Instant.now();
    }

    public void atualizar(){
        this.lastUpdate = Instant.now();
    }

    public void logar(){
        this.lastLogin = Instant.now();
    }

    public void atualizarNome(String name){
        this.name = name;
        this.atualizar();
    }

    public void atualizarEmail(String email){
        this.email = email;
        this.atualizar();
    }

    public void atualizarSenha(String password){
        this.password = password;
        this.atualizar();
    }
}
