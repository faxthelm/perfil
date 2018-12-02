package br.com.enjoei2.perfil.dto;

import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.model.Gender;
import br.com.enjoei2.perfil.model.Size;

import java.util.Date;

public class ClientLoadUpdateDTO {

    private Long clientId;
    private String profileImage;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private String cpf;
    private String ddd;
    private String phone;
    private Gender sex;
    private String cep;
    private String streetName;
    private String addressNumber;
    private String complement;
    private String neighborhood;
    private String state;
    private String city;
    private Size size;
    private int shoeSize;

    public ClientLoadUpdateDTO(Client client){
        this.clientId = client.getClientId();
        this.profileImage = client.getProfileImage();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.cpf = client.getCpf();
        this.ddd = client.getDdd();
        this.phone = client.getPhone();
        this.sex = client.getSex();
        this.cep = client.getCep();
        this.streetName = client.getStreetName();
        this.addressNumber = client.getAddressNumber();
        this.neighborhood = client.getNeighborhood();
        this.complement = client.getComplement();
        this.state = client.getState();
        this.city = client.getCity();
        this.size = client.getSize();
        this.shoeSize = client.getShoeSize();
        this.birthDate = client.getBirthDate();
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
