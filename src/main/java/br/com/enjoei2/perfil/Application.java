package br.com.enjoei2.perfil;

import br.com.enjoei2.perfil.dao.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= {ClientRepository.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);        
    }

}
