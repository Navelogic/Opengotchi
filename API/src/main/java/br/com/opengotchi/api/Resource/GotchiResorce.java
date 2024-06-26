package br.com.opengotchi.api.Resource;

import br.com.opengotchi.api.Entitie.Gotchi;
import br.com.opengotchi.api.Service.GotchiService;
import br.com.opengotchi.api.Util.ConvertDados;
import br.com.opengotchi.api.Util.Model.DadosDigimon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gotchis")
public class GotchiResorce {
    @Autowired
    private GotchiService gotchiService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Olá, esse é o campo de recursos dos Gotchis!");
    }

    // OPERAÇÕES CRUD - Gotchi

    // Criando um Gotchi
    @PostMapping("/create")
    public ResponseEntity<Gotchi> createGotchi(@RequestBody Gotchi gotchi){
        return ResponseEntity.status(201).body(gotchiService.create(gotchi));
    }

    // Deletando um Gotchi
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGotchi(@PathVariable("id") Long id){
        gotchiService.nuke(id);
        return ResponseEntity.noContent().build();
    }

    // Buscando um Gotchi pelo ID
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findGotchiById(@PathVariable("id") Long id){
        return ResponseEntity.ok(gotchiService.findById(id));
    }

    // Listando todos os Gotchis
    @GetMapping("/all")
    public ResponseEntity<?> findAllGotchi(){
        List<Gotchi> gotchis = gotchiService.findAll();
        return ResponseEntity.ok(gotchis);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Olá, esse é o campo de recursos dos Gotchis!");
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(gotchiService.count());
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> nuke() {
        gotchiService.nuke();
        return ResponseEntity.noContent().build();
    }

    // API - Digimon
    @GetMapping("/digimon/id/{id}")
    public ResponseEntity<?> findDigimonById(@PathVariable("id") String id){
        var convertDados = new ConvertDados();
        return ResponseEntity.ok(convertDados.convertJsonToObject(gotchiService.findDigimonById(id), DadosDigimon.class));
    }

    @GetMapping("digimon/nome/{nome}")
    public ResponseEntity<?> findDigimonByName(@PathVariable("nome") String nome) {
        var convertDados = new ConvertDados();
        var validador = convertDados.convertJsonToObject(gotchiService.findDigimonByName(nome), DadosDigimon.class);
        if (validador.id() == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(convertDados.convertJsonToObject(gotchiService.findDigimonByName(nome), DadosDigimon.class));
        }
    }

    @GetMapping("/digimon/all")
    public ResponseEntity<?> findAllDigimon() {
        List<DadosDigimon> digimons = gotchiService.findAllDigimon();
        return ResponseEntity.ok(digimons);
    }


    @GetMapping("/api-test-digimon")
    public ResponseEntity<?> apiTest() {
        var convertDados = new ConvertDados();
        return ResponseEntity.ok(convertDados.convertJsonToObject(gotchiService.apiTestDigimon(), DadosDigimon.class));
    }
}
