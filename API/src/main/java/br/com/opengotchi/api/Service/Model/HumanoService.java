package br.com.opengotchi.api.Service.Model;

import br.com.opengotchi.api.Model.Humano;
import br.com.opengotchi.api.Repository.HumanoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class HumanoService {

    private static final Logger log = LoggerFactory.getLogger(HumanoService.class);
    ILoggerFactory loggerFactory;

    @Autowired
    private HumanoRepository humanoRepository;

    public Long quantidadeDeHumanos(){
        log.info("Quantidade de humanos: {}", humanoRepository.count());
        return humanoRepository.count();
    }

    public List<Humano> findAll(){
        return humanoRepository.findAll();
    }

    public Humano findById(UUID id){
        return humanoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Humano create(Humano humano){
        humano.nascer();
        log.info("Humano criado: {}", humano.getNome());
        return humanoRepository.save(humano);
    }

    @Transactional
    public Humano delete(UUID id){
        Humano humano = humanoRepository.findById(id).orElse(null);
        if(humano != null){
            log.info("Humano deletado: {}", humano.getNome());
            humanoRepository.delete(humano);
        }
        return humano;
    }

    @Transactional
    public void nuke(){
        log.info("Todos os humanos deletados!");
        humanoRepository.deleteAll();
    }

    @Transactional
    public Humano update(Humano humano){
        Humano humanoAtualizado = humanoRepository.findById(humano.getId()).orElseThrow(EntityNotFoundException::new);
        if(Objects.nonNull(humano.getNome())){
            humanoAtualizado.setNome(humano.getNome());
        }
        if(Objects.nonNull(humano.getEmail())){
            humanoAtualizado.setEmail(humano.getEmail());
        }
        if(Objects.nonNull(humano.getSenha())){
            humanoAtualizado.setSenha(humano.getSenha());
        }
        humanoAtualizado.setUltimaAtualizacao(Instant.now());
        log.info("Humano atualizado: {}", humanoAtualizado.getNome());
        return humanoRepository.save(humanoAtualizado);
    }

    public Humano entrar(String email, String senha){
        Humano humanoCredenciado = (Humano) humanoRepository.findByEmailAndSenha(email, senha).orElse(null);
        if(humanoCredenciado == null){
            log.info("Credenciais inválidas!");
            return null;
        } else {
            log.info("Humano entrou: {}", humanoCredenciado.getNome());
            humanoCredenciado.setUltimaEntrada(Instant.now());
            return humanoRepository.save(humanoCredenciado);
        }
    }

}
