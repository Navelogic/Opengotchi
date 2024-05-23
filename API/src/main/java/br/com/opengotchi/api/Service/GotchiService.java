package br.com.opengotchi.api.Service;

import br.com.opengotchi.api.Repository.GotchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GotchiService {
    @Autowired
    private GotchiRepository gotchiRepository;


}
