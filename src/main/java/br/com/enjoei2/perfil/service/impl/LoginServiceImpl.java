package br.com.enjoei2.perfil.service.impl;

import br.com.enjoei2.perfil.dao.ClientRepository;
import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.model.Login;
import br.com.enjoei2.perfil.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public String login(Login login) {
		Client client = clientRepository.findByEmail(login.getLogin());
		if(client==null){
			return "Usuário não cadastrado";
		}
		if(login.getPassword().equals(client.getPassword())){
			return "Senha está incorreta";
		}
		return String.valueOf(client.getClientId());
		
	}

	@Override
	public String recoverPassword(String email) {
		String token = generateToken();
		Client client = clientRepository.findByEmail(email);
		if(client==null){
			return "E-mail não cadastrado";
		}
		String name = client.getFirstName();
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
			return "Erro ao enviar e-mail";
		}
		
	}

	public String generateToken(){
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		// Remover [B@ no começo da palavra gerada
		String[] initialLettersRemoved = token.split("@");
		return initialLettersRemoved[1].toUpperCase();
	}


}
