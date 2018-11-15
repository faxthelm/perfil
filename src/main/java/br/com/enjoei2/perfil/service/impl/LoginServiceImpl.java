package br.com.enjoei2.perfil.service.impl;

import br.com.enjoei2.perfil.dao.ClientRepository;
import br.com.enjoei2.perfil.exceptions.BadRequestException;
import br.com.enjoei2.perfil.exceptions.InternalServerErrorException;
import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.model.Login;
import br.com.enjoei2.perfil.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public String login(Login login) {
		Optional<Client> client = clientRepository.findByEmail(login.getEmail());
		if(!client.isPresent()){
			throw new BadRequestException("login","Usuário não existe");
		}
		if(!login.getPassword().equals(client.get().getPassword())){
			throw new BadRequestException("senha","Senha está incorreta");
		}
		return String.valueOf(client.get().getClientId());
		
	}

	@Override
	public String recoverPassword(String email) {
		String token = generateToken();
		Client client = clientRepository.findByEmail(email).get();
		if(client==null){
			throw new BadRequestException("email", "E-mail não cadastrado");
		}
		String name = client.getFirstName();
		client.setRecoveryToken(token);
		clientRepository.save(client);
		try {
			MimeMessage mail = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper( mail );
			helper.setTo( email );
			helper.setSubject( "Recuperação de Senha - ENJOEI 2" );
			helper.setText("<p>Olá " + name + ", seu token para recuperar sua senha é <b>"
					+ token + "</b>! </p>", true);
			mailSender.send(mail);

			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Erro ao enviar e-mail");
		}
		
	}

	private String generateToken(){
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		// Remover [B@ no começo da palavra gerada
		String[] initialLettersRemoved = token.split("@");
		return initialLettersRemoved[1].toUpperCase();
	}

	@Override
	public String updateRecoveryPassword(String email, String token, String newPassword){
		Client client = clientRepository.findByEmail(email).get();
		if(!client.getRecoveryToken().equals(token)){
			throw new BadRequestException("token", "Token inválido");
		}
		client.setPassword(newPassword);
		client.setRecoveryToken(null);
		clientRepository.save(client);
		return "OK";
	}

}
