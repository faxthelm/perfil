package br.com.enjoei2.perfil.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.enjoei2.perfil.model.User;
import br.com.enjoei2.perfil.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService {

//	@Autowired
//	UserRepository userRepository;

	@Override
	public void registerClient(User user) {
//		userRepository.save(user);
	}

	@Override
	public void updateClient(User user) {
		// TODO adicionar logica de checar o que veio nulo
//		userRepository.save(user);
	}

	@Override
	public void removeClient(Long userId) {
//		userRepository.deleteById(userId);

	}

	@Override
	public Optional<User> retrieveClient(Long userId) {
//		return userRepository.findById(userId);
		return null;
	}

}
