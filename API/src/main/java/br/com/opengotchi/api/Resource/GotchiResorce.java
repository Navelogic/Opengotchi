package br.com.opengotchi.api.Resource;

import br.com.opengotchi.api.Entitie.Gotchi.Gotchi;
import br.com.opengotchi.api.Service.GotchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/gotchis")
public class GotchiResorce {

    @Autowired
    private GotchiService gotchiService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Olá, esse é o campo de recursos dos Gotchis!");
    }

    @GetMapping("/quantidade")
    public ResponseEntity<Long> quantidadeDeGotchis(){
        return ResponseEntity.ok(gotchiService.quantidadeDeGotchis());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Gotchi>> findAll(){
        return ResponseEntity.ok(gotchiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gotchi> findById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(gotchiService.findById(id));
    }

    @PostMapping("/create/{humanoID}")
    public ResponseEntity<Gotchi> createGotchi(@RequestBody Gotchi gotchi, @PathVariable("humanoID") UUID humanoID){
        return ResponseEntity.status(201).body(gotchiService.criarGotchi(gotchi, humanoID));
    }
}
