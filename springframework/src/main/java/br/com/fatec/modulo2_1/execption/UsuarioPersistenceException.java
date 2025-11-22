package br.com.fatec.modulo2_1.execption;

public class UsuarioPersistenceException extends RuntimeException {
    public UsuarioPersistenceException(String message) {
        super(message);
    }

    public UsuarioPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
