package org.banco.exceptions;

public class ValorNegativoException extends  IllegalArgumentException{
    public ValorNegativoException(String message){
        super(message);
    }
}
