package br.com.opengotchi.api.Resource;

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
        gotchiService.delete();
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
