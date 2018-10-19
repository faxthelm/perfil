package br.com.enjoei2.perfil.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.enjoei2.perfil.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
