package br.com.enjoei2.perfil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.service.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@PostMapping()
	public void registerClient(@RequestBody Client client) {
		perfilService.registerClient(client);
	}

}
