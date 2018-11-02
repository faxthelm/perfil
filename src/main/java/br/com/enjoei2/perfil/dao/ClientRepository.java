package br.com.enjoei2.perfil.dao;

import br.com.enjoei2.perfil.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

    @Query("select c from Client where c.email=:email")
    public Client findByEmail(@Param("email") String email);
}
