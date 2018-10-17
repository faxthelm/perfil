package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.User;

public interface IPerfilService {

	public void registerClient(User user);
	
	public void updateClient(User user);
	
	public void removeClient(Long userId);
	
	public User retrieveClient(Long userId);
}
