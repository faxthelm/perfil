package br.com.enjoei2.perfil.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.enjoei2.perfil.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
