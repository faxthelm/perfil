package br.com.enjoei2.perfil.controller;

import br.com.enjoei2.perfil.dto.ClientReducedDTO;
import br.com.enjoei2.perfil.dto.ClientRegisterDTO;
import br.com.enjoei2.perfil.model.Client;
import io.swagger.annotations.ApiOperation;
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

import br.com.enjoei2.perfil.service.IPerfilService;
import java.util.Optional;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	

	
	@Autowired
	private IPerfilService perfilService;

	@ApiOperation(value = "Registra o cliente")
	@PostMapping()
	public @ResponseStatus ResponseEntity<Object> registerClient(@RequestBody ClientRegisterDTO clientRegisterDTO) {
		perfilService.registerClient(clientRegisterDTO);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "Retorna os dados do cliente especificado por id")
	@GetMapping("/{id}")
	public @ResponseBody ClientReducedDTO retrieveClient(@PathVariable("id") Long userId) {
		return perfilService.retrieveClient(userId);
	}

	@ApiOperation(value = "Retorna os dados do cliente especificado pelo seu email")
	@GetMapping("/email/{email}")
	public @ResponseBody ClientReducedDTO retrieveClient(@PathVariable("email") String email) {
		return perfilService.retrieveClientByEmail(email);
	}

	@ApiOperation(value = "Atualiza os dados do perfil de id passado")
	@PutMapping("/{id}")
	public @ResponseStatus ResponseEntity<Object> updateClient(@RequestBody Optional<Client> client, @PathVariable("id") Long userId){
        try {
            perfilService.updateClient(client, userId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta os dados do cliente do id passado")
	@DeleteMapping("/{id}")
	public @ResponseStatus ResponseEntity<Object> removeClient(@PathVariable("id") Long userId){
		perfilService.removeClient(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
