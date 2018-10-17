package br.com.enjoei2.perfil.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enjoei2.perfil.dao.UserRepository;
import br.com.enjoei2.perfil.model.User;
import br.com.enjoei2.perfil.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void registerClient(User client) {
		userRepository.save(client);
	}

	@Override
	public void updateClient(User client) {
		//TODO criar lógica de visualizar o que não veio vazio
		userRepository.save(client);
	}

	@Override
	public void removeClient(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User retrieveClient(Long userId) {
		return userRepository.getOne(userId);
	}

}
