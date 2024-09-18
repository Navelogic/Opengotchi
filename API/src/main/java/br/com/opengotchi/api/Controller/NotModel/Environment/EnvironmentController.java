package br.com.opengotchi.api.Controller.NotModel.Environment;

import br.com.opengotchi.api.Util.Model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/environment")
public class EnvironmentController {

    @Value("${spring.profiles.active}")
    private String environmentName;

    @GetMapping
    public Response environment() {
        if (environmentName.equals("dev")) {
            return new Response("Você está no ambiente de desenvolvimento!");
        } else {
            return new Response("Você está no ambiente de produção!");
        }
    }
}
