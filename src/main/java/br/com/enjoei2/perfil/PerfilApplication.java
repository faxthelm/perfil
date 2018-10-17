package br.com.enjoei2.perfil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class PerfilApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfilApplication.class, args);
	}
}
