package br.com.opengotchi.api.Config.Exception;

import br.com.opengotchi.api.Config.Exception.Gotchi.GotchiNaoEncontradoExeption;
import br.com.opengotchi.api.Config.Exception.SecureSave.SecureSaveException;
import br.com.opengotchi.api.Config.Exception.Usuario.UsuarioFaltandoAtributosException;
import br.com.opengotchi.api.Config.Exception.Usuario.UsuarioJaExistenteExeption;
import br.com.opengotchi.api.Config.Exception.Usuario.UsuarioNaoEncontradoExeption;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UsuarioFaltandoAtributosException.class)
    public ResponseEntity<Object> handleUsuarioFaltandoAtributosException(UsuarioFaltandoAtributosException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RespostaParaErro(ex.getMessage()));
    }

    @ExceptionHandler(UsuarioJaExistenteExeption.class)
    public ResponseEntity<Object> handleUsuarioJaExistenteExeption(UsuarioJaExistenteExeption ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new RespostaParaErro(ex.getMessage()));
    }

    @ExceptionHandler(UsuarioNaoEncontradoExeption.class)
    public ResponseEntity<Object> handleUsuarioNaoEncontradoExeption(UsuarioNaoEncontradoExeption ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RespostaParaErro(ex.getMessage()));
    }

    @ExceptionHandler(SecureSaveException.class)
    public ResponseEntity<Object> handleSecureSaveException(SecureSaveException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RespostaParaErro(ex.getMessage()));
    }

    @ExceptionHandler(GotchiNaoEncontradoExeption.class)
        public ResponseEntity<Object> handleGotchiNaoEncontradoExeption(GotchiNaoEncontradoExeption ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RespostaParaErro(ex.getMessage()));
        }

    @Setter
    @Getter
    public static class RespostaParaErro {
        private String msg;

        public RespostaParaErro(String msg) {
            this.msg = msg;
        }
    }
}
