package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.Login;

public interface ILoginService {

	String login(Login login);
	String recoverPassword(String email);

    String updateRecoveryPassword(String email, String token, String newPassword);
}
