package br.com.enjoei2.perfil.model;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(appliesTo = "client")
public class Client {

	@Id
    @GeneratedValue
	private Long clientId;
	
	@Column(name = "profile_image")
	private byte[] profileImage;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "ddd", nullable = false)
	private String ddd;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Column(name = "sex", nullable = false)
	private Gender sex;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "address_number")
	private String addressNumber;
	
	@Column(name = "complement")
	private String complement;
	
	@Column(name = "neighborhood")
	private String neighborhood;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;

	@Column(name = "likes")
	private Long likes;

	@Column(name = "dislikes")
	private Long dislikes;

	@Column(name= "sales")
	private Long sales;

	@Column(name = "size")
	private Size size;

	@Column(name = "shoe_size")
	private int shoeSize;

	@Column(name = "recovery_token")
	private String recoveryToken;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getRecoveryToken() {
		return recoveryToken;
	}

	public void setRecoveryToken(String recoveryToken) {
		this.recoveryToken = recoveryToken;
	}

	// Nao fazemos o update de ID nem de recovery_token nessa parte.
	public Client update(Client newClient) {
		if (this.profileImage != null) {
			if (!this.profileImage.equals(newClient.getFirstName()) && newClient.getProfileImage() != null)
				this.setProfileImage(newClient.getProfileImage());
		}
		//Estão marcados como NOT NULL no bd, dessa forma se for atualizar com certeza haverá dados.
		if (!this.firstName.equals(newClient.getFirstName()) && newClient.getFirstName() != null)
			this.setFirstName(newClient.getFirstName());
		if (!this.lastName.equals(newClient.getLastName()) && newClient.getLastName() != null)
			this.setLastName(newClient.getLastName());
		if (!this.email.equals(newClient.getEmail()) && newClient.getEmail() != null)
			this.setEmail(newClient.getEmail());
		if (!this.password.equals(newClient.getPassword()) && newClient.getPassword() != null)
			this.setPassword(newClient.getPassword());
		if (!this.cpf.equals(newClient.getCpf()) && newClient.getCpf() != null)
			this.setCpf(newClient.getCpf());
		if (!this.ddd.equals(newClient.getDdd()) && newClient.getDdd() != null)
			this.setDdd(newClient.getDdd());
		if (!this.phone.equals(newClient.getPhone()) && newClient.getPhone() != null)
			this.setPhone(newClient.getPhone());
		if (!this.birthDate.equals(newClient.getBirthDate()) && newClient.getBirthDate() != null)
			this.setBirthDate(newClient.getBirthDate());
		if (!this.sex.equals(newClient.getSex()) && newClient.getSex() != null)
			this.setSex(newClient.getSex());
		if (this.cep != null) {
			if (!this.cep.equals(newClient.getCep()) && newClient.getCep() != null)
				this.setCep(newClient.getCep());
		}
		if (this.streetName != null) {
			if (!this.streetName.equals(newClient.getStreetName()) && newClient.getStreetName() != null)
				this.setStreetName(newClient.getStreetName());
		}
		if (this.addressNumber != null) {
			if (!this.addressNumber.equals(newClient.getAddressNumber()) && newClient.getAddressNumber() != null)
				this.setAddressNumber(newClient.getAddressNumber());
		}
		if (this.complement != null) {
			if (!this.complement.equals(newClient.getComplement()) && newClient.getComplement() != null)
				this.setComplement(newClient.getComplement());
		}
		if (this.neighborhood != null) {
			if (!this.neighborhood.equals(newClient.getNeighborhood()) && newClient.getNeighborhood() != null)
				this.setNeighborhood(newClient.getNeighborhood());
		}
		if (this.state != null) {
			if (!this.state.equals(newClient.getState()) && newClient.getState() != null)
				this.setState(newClient.getState());
		}
		if (this.city != null) {
			if (!this.city.equals(newClient.getCity()) && newClient.getCity() != null)
				this.setCity(newClient.getCity());
		}
		if (this.likes != null) {
			if (!this.likes.equals(newClient.getLikes()) && newClient.getLikes() != null)
				this.setLikes(newClient.getLikes());
		}
		if (this.dislikes != null) {
			if (!this.dislikes.equals(newClient.getDislikes()) && newClient.getDislikes() != null)
				this.setDislikes(newClient.getDislikes());
		}
		if (this.sales != null) {
			if (!this.sales.equals(newClient.getSales()) && newClient.getSales() != null)
				this.setSales(newClient.getSales());
		}
		if (this.size != null) {
			if (!this.size.equals(newClient.getSize()) && newClient.getSize() != null)
				this.setSize(newClient.getSize());
		}
		if (this.shoeSize != 0) {
			if (this.shoeSize != (newClient.getShoeSize()) && newClient.getShoeSize() != 0)
				this.setShoeSize(newClient.getShoeSize());
		}
		return this;
	}
}
