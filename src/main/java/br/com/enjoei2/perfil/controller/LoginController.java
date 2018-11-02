package br.com.enjoei2.perfil.controller;

import br.com.enjoei2.perfil.model.Login;
import br.com.enjoei2.perfil.service.ILoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    ILoginService iLoginService;

    @ApiOperation(value = "Requisitar recuperação de senha através do e-mail (Envio de token para o e-mail em questão)")
    @GetMapping("/recoverPassword")
    public ResponseEntity recoverPassword(@RequestParam String email){
        return ResponseEntity.ok(iLoginService.recoverPassword(email));
    }

    @ApiOperation(value = "Realizar login (Checagem se usuário existe e se senha está correta)")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login){
        return ResponseEntity.ok(iLoginService.login(login));
    }

    @ApiOperation(value = "Atualizar senha através do token de recuperação enviado por e-mail")
    @PostMapping("/updateRecoveredPassword")
    public ResponseEntity updateRecoveredPassword(@RequestParam String email, @RequestParam String token, @RequestParam String newPassword){
        return ResponseEntity.ok(iLoginService.updateRecoveryPassword(email, token, newPassword));
    }

}
