package br.com.enjoei2.perfil.dto;

public class SucessResponseDTO {
    private String message;

    public SucessResponseDTO(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
