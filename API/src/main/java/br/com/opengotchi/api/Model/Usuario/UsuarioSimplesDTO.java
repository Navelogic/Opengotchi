package br.com.opengotchi.api.Model.Usuario;

/**
 * Um Objeto de Transferência de Dados (DTO) para a entidade Usuario.
 * Esta classe é usada para transferir dados entre diferentes camadas da aplicação.
 */
public record UsuarioSimplesDTO(
        Long id,
        String nome
) {
    /**
     * Converte uma entidade Usuario para um UsuarioSimplesDTO.
     *
     * @param usuario a entidade Usuario a ser convertida
     * @return uma nova instância de UsuarioSimplesDTO com dados da entidade Usuario fornecida
     */
    public static UsuarioSimplesDTO daEntidade(Usuario usuario) {
        return new UsuarioSimplesDTO(
                usuario.getId(),
                usuario.getNome()
        );
    }

    /**
     * Converte este UsuarioSimplesDTO para uma entidade Usuario.
     *
     * @return uma nova instância de Usuario com dados deste UsuarioSimplesDTO
     */
    public Usuario paraEntidade() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        return usuario;
    }
}