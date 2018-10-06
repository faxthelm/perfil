package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.Client;

public interface PerfilService {

	public void registerClient(Client client);
	
	public void updateClient(Client client);
	
	public void removeClient(String clientId);
	
	public Client retrieveClient(String clientId);
}
