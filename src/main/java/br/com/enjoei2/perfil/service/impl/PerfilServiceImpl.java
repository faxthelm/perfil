package br.com.enjoei2.perfil.service.impl;

import java.util.Optional;

import br.com.enjoei2.perfil.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enjoei2.perfil.dao.ClientRepository;
import br.com.enjoei2.perfil.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void registerClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void updateClient(Client client) {
		// TODO adicionar logica de checar o que veio nulo
		clientRepository.save(client);
	}

	@Override
	public void removeClient(Long userId) {
		clientRepository.deleteById(userId);
	}

	@Override
	public Optional<Client> retrieveClient(Long userId) {
		return clientRepository.findById(userId);
	}

}
