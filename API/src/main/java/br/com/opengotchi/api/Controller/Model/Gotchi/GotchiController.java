package br.com.opengotchi.api.Controller.Model.Gotchi;

import br.com.opengotchi.api.Model.Gotchi.Gotchi;
import br.com.opengotchi.api.Service.Model.Gotchi.GotchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/gotchi")
public class GotchiController {
    private final GotchiService gotchiService;

    @Autowired
    public GotchiController(GotchiService gotchiService) {
        this.gotchiService = gotchiService;
    }

    @GetMapping
    public ResponseEntity<List<Gotchi>> findAll(){
        return ResponseEntity.ok(gotchiService.findAll());
    }

    @GetMapping("/id/{id}")
    public Gotchi findById(@PathVariable Long id){
        return gotchiService.findById(id);
    }

    @PostMapping("/{codigo}")
    @ResponseBody
    public Gotchi save(@RequestBody Gotchi gotchi, @PathVariable String codigo) {
        return gotchiService.save(gotchi,codigo);
    }
}