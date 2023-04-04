package com.example.perladelmediterraneo.controllers;

import com.example.perladelmediterraneo.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtentiController {

    @Autowired
    UtentiService utentiService;

    @PostMapping("/login/processo")
    public String login(@RequestParam String username, @RequestParam String password){

        UtentiService.LoginResponse response = utentiService.validateLogin(username, password);

        return switch(response){
            case SUCCESSO -> "redirect:/home?result=success";
            case NESSUN_UTENTE_TROVATO -> "redirect:/home?result=no_utente";
            case PASSWORD_SBAGLIATA -> "redirect:/home?result=no_psw";
        };

    }

    @GetMapping("/home")
    public String home(@RequestParam String result, Model model){
        model.addAttribute("result", result);
        return "/home";
    }


}
