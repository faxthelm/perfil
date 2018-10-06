package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.Login;

public interface LoginService {

	public String login(Login login);
	public void recoverPassword(String email);
}
