package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.dto.ClientReducedDTO;
import br.com.enjoei2.perfil.dto.ClientRegisterDTO;
import br.com.enjoei2.perfil.model.Client;

import java.util.Optional;

public interface IPerfilService {

	void registerClient(ClientRegisterDTO clientRegisterDTO);
	
	void updateClient(Optional<Client> client, Long userId) throws Exception;
	
	void removeClient(Long userId);
	
	ClientReducedDTO retrieveClient(Long userId) throws Exception;

	ClientReducedDTO retrieveClientByEmail(String email) throws Exception;
}
