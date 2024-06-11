package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Entitie.Humano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanoRepository extends JpaRepository<Humano, Long>{

}
