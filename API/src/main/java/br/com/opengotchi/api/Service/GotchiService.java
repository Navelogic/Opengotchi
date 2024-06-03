package br.com.opengotchi.api.Service;

import br.com.opengotchi.api.Entitie.Gotchi;
import br.com.opengotchi.api.Repository.GotchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GotchiService {
    @Autowired
    private GotchiRepository gotchiRepository;

    public List<Gotchi> findAll(){
        return gotchiRepository.findAll();
    }

    public Long count(){
        return gotchiRepository.count();
    }

    public void delete(){
        gotchiRepository.deleteAll();
    }
}