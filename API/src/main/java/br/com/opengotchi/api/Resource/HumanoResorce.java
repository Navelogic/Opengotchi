package br.com.opengotchi.api.Resource;

import br.com.opengotchi.api.Entitie.Humano;
import br.com.opengotchi.api.Service.HumanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/humanos")
public class HumanoResorce {
    @Autowired
    private HumanoService humanoService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Olá, esse é o campo de recursos dos Humanos!");
    }

    // OPERAÇÕES CRUD - Humano

    // Criando um Humano
    @PostMapping("/create")
    public ResponseEntity<Humano> createHumano(@RequestBody Humano humano){
        return ResponseEntity.status(201).body(humanoService.create(humano));
    }

    // Deletanto um Humano
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHumano(@PathVariable("id") Long id){
        humanoService.nuke(id);
        return ResponseEntity.noContent().build();
    }

    // Buscando um Humano pelo ID
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findHumanoById(@PathVariable("id") Long id){
        return ResponseEntity.ok(humanoService.findById(id));
    }

    // Listando todos os Humanos
    @GetMapping("/all")
    public ResponseEntity<?> findAllHumano(){
        return ResponseEntity.ok(humanoService.findAll());
    }
}
