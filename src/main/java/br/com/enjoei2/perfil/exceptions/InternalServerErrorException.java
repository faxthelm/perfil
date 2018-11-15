package br.com.enjoei2.perfil.exceptions;

public class InternalServerErrorException extends RuntimeException {

    private final String message;

    public InternalServerErrorException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
