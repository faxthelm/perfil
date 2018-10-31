package br.com.enjoei2.perfil.service;

import java.util.Optional;

import br.com.enjoei2.perfil.model.Client;

public interface IPerfilService {

	void registerClient(Client client);
	
	void updateClient(Client client);
	
	void removeClient(Long userId);
	
	Optional<Client> retrieveClient(Long userId);
}
