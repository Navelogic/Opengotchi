package br.com.opengotchi.api.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloResource {

    @GetMapping
    public String hello() {
        return "Olá, eu sou o OpenGotchi! É um prazer te conhecer!";
    }
}
