package br.com.opengotchi.api.Resource;

import br.com.opengotchi.api.Service.GotchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/api-test")
    public ResponseEntity<String> apiTest() {
        return ResponseEntity.ok(gotchiService.apiTest());
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> delete() {
        gotchiService.delete();
        return ResponseEntity.noContent().build();
    }
}
