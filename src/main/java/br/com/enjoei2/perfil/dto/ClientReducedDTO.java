package br.com.enjoei2.perfil.dto;

import br.com.enjoei2.perfil.model.Client;

import java.util.Optional;

public class ClientReducedDTO {

    private Long clientId;

    private byte[] profileImage;

    private String firstName;

    private String lastName;

    private Long likes;

    private Long dislikes;

    private Long sales;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public ClientReducedDTO (Client client) {
        this.setClientId(client.getClientId());
        this.setProfileImage(client.getProfileImage());
        this.setFirstName(client.getFirstName());
        this.setLastName(client.getLastName());
        this.setLikes(client.getLikes());
        this.setDislikes(client.getDislikes());
        this.setSales(client.getSales());
    }
}
