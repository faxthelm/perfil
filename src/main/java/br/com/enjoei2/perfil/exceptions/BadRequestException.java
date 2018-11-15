package br.com.enjoei2.perfil.exceptions;

public class BadRequestException extends RuntimeException {

    private final String field;

    private final String message;

    public BadRequestException(final String field, final String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
