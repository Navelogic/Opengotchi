package br.com.opengotchi.api.Controller.Model.Usuario;

import br.com.opengotchi.api.Model.Usuario.Usuario;
import br.com.opengotchi.api.Model.Usuario.UsuarioDTO;
import br.com.opengotchi.api.Model.Usuario.UsuarioSimplesDTO;
import br.com.opengotchi.api.Service.Model.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioSimplesDTO> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @GetMapping("/email/{email}")
    public UsuarioDTO findByEmail(@PathVariable String email){
        return usuarioService.findByEmail(email);
    }

    @GetMapping("/count")
    public Long countUsuarios(){
        return usuarioService.countUsuarios();
    }

    @PostMapping
    public UsuarioDTO save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/login/{email}/{senha}")
    public Long login(@PathVariable String email, @PathVariable String senha){
        return usuarioService.login(email, senha);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.delete(id);
    }

    @GetMapping("/respostaCompleta/{id}")
    public Usuario respostaCompleta(@PathVariable Long id){
        return usuarioService.respostaCompleta(id);
    }
}
