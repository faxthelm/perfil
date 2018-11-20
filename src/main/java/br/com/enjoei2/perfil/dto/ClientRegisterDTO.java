package br.com.enjoei2.perfil.dto;


import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.model.Gender;

import java.util.Date;

public class ClientRegisterDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String cpf;

    private String ddd;

    private String phone;

    private Date birthDate;

    private Gender sex;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public Client transformToClient(){
        Client client = new Client();
        // Profile image only gets added through updates
        client.setProfileImage(null);
        client.setFirstName(this.firstName);
        client.setLastName(this.lastName);
        client.setEmail(this.email);
        client.setPassword(this.password);
        client.setCpf(this.cpf);
        client.setDdd(this.ddd);
        client.setPhone(this.phone);
        client.setBirthDate(this.birthDate);
        client.setSex(this.sex);
        return client;
    }
}
