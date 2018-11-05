package br.com.enjoei2.perfil.service.impl;

import br.com.enjoei2.perfil.dao.ClientRepository;
import br.com.enjoei2.perfil.dto.ClientReducedDTO;
import br.com.enjoei2.perfil.dto.ClientRegisterDTO;
import br.com.enjoei2.perfil.exceptions.EmailAlreadyInUseException;
import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements IPerfilService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void registerClient(ClientRegisterDTO clientRegisterDTO) {
		Client client = clientRegisterDTO.transformToClient();
		if(!clientRepository.findByEmail(client.getEmail()).isPresent())
			clientRepository.save(client);
		else
			throw new EmailAlreadyInUseException(client.getEmail());
	}

	@Override
	public void updateClient(Optional<Client> client, Long userId) {
		if (client.get() != null) {
			Client savedClient = clientRepository.findById(userId).get();
			savedClient.update(client.get());
			clientRepository.save(savedClient);
		}

	}

	@Override
	public void removeClient(Long userId) {
		clientRepository.deleteById(userId);
	}

	@Override
	public ClientReducedDTO retrieveClient(Long userId) {
		return new ClientReducedDTO((clientRepository.findById(userId)).get());
	}


	@Override
	public ClientReducedDTO retrieveClientByEmail(String email) {
		return new ClientReducedDTO((clientRepository.findByEmail(email)).get());
	}

}
