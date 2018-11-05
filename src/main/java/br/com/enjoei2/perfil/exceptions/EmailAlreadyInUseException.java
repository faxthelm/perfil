package br.com.enjoei2.perfil.exceptions;

public class EmailAlreadyInUseException extends RuntimeException{
    public EmailAlreadyInUseException(String email) {
        super("O e-mail " + email + " já está em uso!");
    }
}
