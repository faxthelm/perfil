package br.com.enjoei2.perfil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.enjoei2.perfil.model.User;
import br.com.enjoei2.perfil.service.IPerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private IPerfilService perfilService;
	
	@PostMapping()
	public @ResponseStatus ResponseEntity<Object> registerClient(@RequestBody User client) {
		perfilService.registerClient(client);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody User retrieveClient(@PathVariable("id") String clientId) {		
		return perfilService.retrieveClient(clientId);
	}
	
	@PutMapping("/{id}")
	public @ResponseStatus ResponseEntity<Object> updateClient(@RequestBody User client){
		perfilService.updateClient(client);
		return null;
	}
	
	@DeleteMapping("/{id}")
	public @ResponseStatus ResponseEntity<Object> removeClient(@PathVariable("id") String clientId){
		perfilService.removeClient(clientId);
		return null;
	}

}
