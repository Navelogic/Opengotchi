package br.com.opengotchi.api.Model.Usuario;

import java.time.Instant;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        Instant ultima_entrada,
        Instant ultima_atualizacao,
        Instant criado_em
) {
    public static UsuarioDTO daEntidade(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getUltima_entrada(),
                usuario.getUltima_atualizacao(),
                usuario.getCriado_em()
        );
    }

    public Usuario paraEntidade() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id());
        usuario.setNome(this.nome());
        usuario.setEmail(this.email());
        usuario.setUltima_entrada(this.ultima_entrada());
        usuario.setUltima_atualizacao(this.ultima_atualizacao());
        usuario.setCriado_em(this.criado_em());
        return usuario;
    }
}
