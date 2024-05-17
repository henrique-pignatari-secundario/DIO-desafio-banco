package org.banco.exceptions;

public class ClienteInexistenteException extends RuntimeException{
    public ClienteInexistenteException(String message) {
        super(message);
    }
}
