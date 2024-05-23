package br.com.opengotchi.api.Resource;

import br.com.opengotchi.api.Service.GotchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gotchis")
public class GotchiResorce {
    @Autowired
    private GotchiService gotchiService;

    @GetMapping("/hello")
    private ResponseEntity<String> hello() {
        return ResponseEntity.ok("Olá, esse é o campo de recursos dos Gotchis!");
    }
}
