package br.com.opengotchi.api.Service.Model;

import br.com.opengotchi.api.Config.Exception.Usuario.*;
import br.com.opengotchi.api.Model.Usuario.*;
import br.com.opengotchi.api.Repository.UsuarioRepository;
import br.com.opengotchi.api.Util.SecureSaveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioSimplesDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioSimplesDTO::daEntidade)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        return UsuarioDTO.daEntidade(
                usuarioRepository.findById(id)
                        .orElseThrow(() -> new UsuarioNaoEncontradoExeption("Usuário não encontrado com o id: " + id))
        );
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByEmail(String email) {
        return UsuarioDTO.daEntidade(
                usuarioRepository.findByEmail(email)
                        .orElseThrow(() -> new UsuarioNaoEncontradoExeption("Usuário não encontrado com o email: " + email))
        );
    }

    @Transactional(readOnly = true)
    public Long countUsuarios() {
        return usuarioRepository.count();
    }

    @Transactional
    public UsuarioDTO save(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            throw new UsuarioFaltandoAtributosException("Usuário faltando atributos obrigatórios");
        }

        String emailCriptografado = SecureSaveUtil.secureSaveEmail(usuario.getEmail());

        if (usuarioRepository.findByEmail(emailCriptografado).isPresent()) {
            throw new UsuarioJaExistenteExeption("Usuário já existente com o email fornecido");
        }

        usuario.setSenha(SecureSaveUtil.secureSavePassword(usuario.getSenha()));
        usuario.setEmail(emailCriptografado);
        Instant now = Instant.now();
        usuario.setCriado_em(now);
        usuario.setUltima_entrada(now);
        usuario.setUltima_atualizacao(now);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return findById(usuarioSalvo.getId());
    }

    @Transactional
    public Long logar(String email, String senha) {
        String emailCriptografado = SecureSaveUtil.secureSaveEmail(email);
        String senhaCriptografada = SecureSaveUtil.secureSavePassword(senha);

        Usuario usuario = usuarioRepository.findByEmail(emailCriptografado)
                .orElseThrow(() -> new UsuarioNaoEncontradoExeption("E-mail ou senha incorretos"));

        if (!usuario.getSenha().equals(senhaCriptografada)) {
            throw new UsuarioNaoEncontradoExeption("E-mail ou senha incorretos");
        }

        usuario.setUltima_entrada(Instant.now());
        usuarioRepository.save(usuario);

        return usuario.getId();
    }

    @Transactional
    public UsuarioDTO atualizar(Long id, Usuario usuario) {
        Usuario usuarioBanco = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoExeption("Usuário não encontrado com o id: " + id));

        if (usuario.getNome() != null) {
            usuarioBanco.setNome(usuario.getNome());
        }

        if (usuario.getEmail() != null) {
            String novoEmailCriptografado = SecureSaveUtil.secureSaveEmail(usuario.getEmail());
            if (!novoEmailCriptografado.equals(usuarioBanco.getEmail()) &&
                    usuarioRepository.findByEmail(novoEmailCriptografado).isPresent()) {
                throw new UsuarioJaExistenteExeption("Email já está em uso");
            }
            usuarioBanco.setEmail(novoEmailCriptografado);
        }

        if (usuario.getSenha() != null) {
            usuarioBanco.setSenha(SecureSaveUtil.secureSavePassword(usuario.getSenha()));
        }

        usuarioBanco.setUltima_atualizacao(Instant.now());
        Usuario usuarioAtualizado = usuarioRepository.save(usuarioBanco);
        return findById(usuarioAtualizado.getId());
    }

    @Transactional
    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoExeption("Usuário não encontrado com o id: " + id));
        usuarioRepository.delete(usuario);
    }
}