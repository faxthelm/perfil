package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.User;

public interface IPerfilService {

	public void registerClient(User client);
	
	public void updateClient(User client);
	
	public void removeClient(Long userId);
	
	public User retrieveClient(Long userId);
}
