package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Util.Model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    @Query(value = "SELECT * FROM cores ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Color getRandom();
}