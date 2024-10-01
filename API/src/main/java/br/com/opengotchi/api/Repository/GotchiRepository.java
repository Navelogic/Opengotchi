package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GotchiRepository extends JpaRepository<Gotchi, Long> {
}
