package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Entitie.Humano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HumanoRepository extends JpaRepository<Humano, UUID>{
    Optional<Object> findByEmailAndSenha(String email, String senha);
}
