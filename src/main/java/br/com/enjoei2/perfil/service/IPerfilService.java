package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.dto.ClientLoadUpdateDTO;
import br.com.enjoei2.perfil.dto.ClientReducedDTO;
import br.com.enjoei2.perfil.dto.ClientRegisterDTO;
import br.com.enjoei2.perfil.model.Client;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Optional;

public interface IPerfilService {

	void registerClient(ClientRegisterDTO clientRegisterDTO);
	
	void updateClient(Optional<Client> client, Long userId) throws Exception;
	
	void removeClient(Long userId);
	
	ClientReducedDTO retrieveClient(Long userId) throws Exception;

	ClientReducedDTO retrieveClientByEmail(String email) throws Exception;

	ClientLoadUpdateDTO retrieveClientFullData(Long id) throws Exception;

	Boolean updateLikes(Boolean increase, Long userId);

	Boolean updateDislikes(Boolean increase, Long userId);

	Boolean updateSales(Boolean increase, Long userId);
}
