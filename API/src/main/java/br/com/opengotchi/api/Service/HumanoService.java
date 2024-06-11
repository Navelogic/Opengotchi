package br.com.opengotchi.api.Service;

import br.com.opengotchi.api.Entitie.Humano;
import br.com.opengotchi.api.Repository.HumanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanoService {
    @Autowired
    private HumanoRepository humanoRepository;

    // OPERAÇÕES CRUD - Humano

    // Criando um Humano
    public Humano create(Humano humano){
        humano.setCreatedAt(java.time.Instant.now());
        humano.setLastLogin(java.time.Instant.now());
        humano.setLastUpdate(java.time.Instant.now());
        return humanoRepository.save(humano);
    }

    // Deletando um Humano
    public void delete(Long id){
        humanoRepository.deleteById(id);
    }

    // Atualizando um Humano
    public Humano update(Humano humano){
        humano.nasceu();
        return humanoRepository.save(humano);
    }

    // Listando um Humano pelo id
    public Humano findById(Long id){
        return humanoRepository.findById(id).orElse(null);
    }

    // Listando todos os Humanos
    public List<Humano> findAll(){
        return humanoRepository.findAll();
    }

    // FIM OPERAÇÕES CRUD - Humano

    public Long count(){
        return humanoRepository.count();
    }

    public void nuke(Long id){
        humanoRepository.deleteAll();
    }
}
