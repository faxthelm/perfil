package br.com.enjoei2.perfil.dao;

import br.com.enjoei2.perfil.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}
