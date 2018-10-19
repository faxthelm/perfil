package br.com.enjoei2.perfil.controller;

import br.com.enjoei2.perfil.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    ILoginService iLoginService;

    @GetMapping("/recoverPassword")
    public String recoverPassword(@RequestParam String email){
        return iLoginService.recoverPassword(email);
    }
}
