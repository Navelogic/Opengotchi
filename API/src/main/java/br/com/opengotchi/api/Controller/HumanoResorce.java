package br.com.opengotchi.api.Controller;

import br.com.opengotchi.api.Model.Humano;
import br.com.opengotchi.api.Service.Model.HumanoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/humanos")
public class HumanoResorce {

    @Autowired
    private HumanoService humanoService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Olá, esse é o campo de recursos dos Humanos!");
    }

    @GetMapping("/quantidade")
    public ResponseEntity<Long> quantidadeDeHumanos(){
        return ResponseEntity.ok(humanoService.quantidadeDeHumanos());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Humano>> findAll(){
        return ResponseEntity.ok(humanoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Humano> findById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(humanoService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Humano> createHumano(@RequestBody Humano humano){
        return ResponseEntity.status(201).body(humanoService.create(humano));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Humano> updateHumano(@PathVariable("id") UUID id, @RequestBody Humano humano){
        try {
            humano.setId(id);
            return ResponseEntity.ok(humanoService.update(humano));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Humano> deleteHumano(@PathVariable("id") UUID id){
        return ResponseEntity.ok(humanoService.delete(id));
    }

    @DeleteMapping("/nuke")
    public ResponseEntity<Void> nuke(){
        humanoService.nuke();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/entrar/{email}/{senha}")
    public ResponseEntity<Humano> entrar(@PathVariable("email") String email, @PathVariable("senha") String senha){
        return ResponseEntity.ok(humanoService.entrar(email, senha));
    }
}
