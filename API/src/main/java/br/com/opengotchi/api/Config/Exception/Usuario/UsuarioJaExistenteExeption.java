package br.com.opengotchi.api.Config.Exception.Usuario;

public class UsuarioJaExistenteExeption extends RuntimeException {
    public UsuarioJaExistenteExeption(String message) {
        super(message);
    }
}
