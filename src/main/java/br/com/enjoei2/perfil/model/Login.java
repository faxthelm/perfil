package br.com.enjoei2.perfil.model;

import io.swagger.annotations.ApiModelProperty;

public class Login {

	@ApiModelProperty(value = "E-mail", example = "gabriel.martins@gmail.com")
	private String email;
	@ApiModelProperty(value = "Senha")
	private String password;

	public String getLogin() {
		return email;
	}

	public void setLogin(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
