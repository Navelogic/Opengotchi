package br.com.opengotchi.api.Repository;

import br.com.opengotchi.api.Util.Model.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends JpaRepository<Cor, Long> {

    @Query(value = "SELECT * FROM cores ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Cor getRandom();
}