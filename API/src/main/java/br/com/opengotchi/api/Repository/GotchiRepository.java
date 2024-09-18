package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Entitie.Gotchi.Gotchi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GotchiRepository extends JpaRepository<Gotchi, UUID> {
}
