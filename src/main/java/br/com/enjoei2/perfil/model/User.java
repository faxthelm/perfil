package br.com.enjoei2.perfil.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class User {

	@Column(columnDefinition = "userId")
	private String userId;
	@Column(columnDefinition = "profileImage")
	private byte[] profileImage;
	@Column(columnDefinition = "name")
	private String name;
	@Column(columnDefinition = "email")
	private String email;
	@Column(columnDefinition = "cpf")
	private String cpf;
	@Column(columnDefinition = "ddd")
	private String ddd;
	@Column(columnDefinition = "phone")
	private String phone;
	@Column(columnDefinition = "birthDate")
	private Date birthDate;
	@Column(columnDefinition = "sex")
	private Boolean sex;
	@Column(columnDefinition = "cep")
	private String cep;
	@Column(columnDefinition = "streetName")
	private String streetName;
	@Column(columnDefinition = "addressNumber")
	private String addressNumber;
	@Column(columnDefinition = "complement")
	private String complement;
	@Column(columnDefinition = "neighborhood")
	private String neighborhood;
	@Column(columnDefinition = "state")
	private String state;
	@Column(columnDefinition = "city")
	private String city;

	public String getClientId() {
		return userId;
	}

	public void setClientId(String clientId) {
		this.userId = clientId;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
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

	public String getNumber() {
		return addressNumber;
	}

	public void setNumber(String number) {
		this.addressNumber = number;
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

}
