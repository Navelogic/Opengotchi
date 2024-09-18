package br.com.opengotchi.api.Controller.NotModel.Hello;

import br.com.opengotchi.api.Util.Model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping
    public Response hello() {
        return new Response("Olá, eu sou o OpenGotchi! É um prazer te conhecer!");
    }
}
