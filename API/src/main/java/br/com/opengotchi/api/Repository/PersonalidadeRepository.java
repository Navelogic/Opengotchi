package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Util.Model.Personalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalidadeRepository extends JpaRepository<Personalidade, Long> {

    @Query(value = "SELECT * FROM personalidades ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Personalidade getRandom();
}
