package br.com.enjoei2.perfil.service.impl;

import br.com.enjoei2.perfil.dao.ClientRepository;
import br.com.enjoei2.perfil.exceptions.BadRequestException;
import br.com.enjoei2.perfil.model.Client;
import br.com.enjoei2.perfil.model.Login;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

    @InjectMocks
    LoginServiceImpl loginService;

    @Mock
    ClientRepository clientRepository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowBadRequestExceptionWhenInvalidUser(){
        exception.expect(BadRequestException.class);
        exception.expectMessage("Usuário não existe");

        Login login = new Login();
        login.setEmail("teste@teste.com");
        login.setPassword("1234");

        when(clientRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        loginService.login(login);
    }

    @Test
    public void shouldThrowBadRequestExceptionWhenInvalidPassword(){
        exception.expect(BadRequestException.class);
        exception.expectMessage("Senha está incorreta");

        Login login = new Login();
        login.setEmail("teste@teste.com");
        login.setPassword("1234");

        Client clientInfo = new Client();
        clientInfo.setEmail("teste@teste.com");
        clientInfo.setPassword("4567");
        Optional<Client> client = Optional.of(clientInfo);

        when(clientRepository.findByEmail(anyString())).thenReturn(client);
        loginService.login(login);
    }

    @Test
    public void shouldReturnClientIdWhenLoggedWithSuccess(){

        Login login = new Login();
        login.setEmail("teste@teste.com");
        login.setPassword("1234");

        Client clientInfo = new Client();
        clientInfo.setClientId(1L);
        clientInfo.setEmail("teste@teste.com");
        clientInfo.setPassword("1234");
        Optional<Client> client = Optional.of(clientInfo);

        when(clientRepository.findByEmail(anyString())).thenReturn(client);
        assertEquals("1", loginService.login(login));
    }



}