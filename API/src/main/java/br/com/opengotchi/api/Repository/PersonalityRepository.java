package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Util.Model.Personality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalityRepository extends JpaRepository<Personality, Long> {

    @Query(value = "SELECT * FROM personalidades ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Personality getRandom();
}
