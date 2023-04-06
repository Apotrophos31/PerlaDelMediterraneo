package com.example.perladelmediterraneo.controllers;

import com.example.perladelmediterraneo.model.Utente;
import com.example.perladelmediterraneo.services.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @GetMapping("/api/error")
    public String apiLoginError(@RequestParam String message, Model model) {
        model.addAttribute("message", message); // TODO: SOSTITUIRE CON SESSION
        return "/api/error";
    }

    @PostMapping("/api/login")
    public String apiLogin(@RequestParam String username, @RequestParam String password, HttpSession session) throws NoSuchAlgorithmException {

        //PROCESSO DI LOGIN QUI
        Optional<Utente> utente = utenteService.loadByUsername(username);

        if (utente.isPresent()) {

            Utente u = utente.get();

            String utentePassword = u.getPassword();
            String encryptedPassword = encrypt(password);

            if (utentePassword.equals(encryptedPassword)) {
                session.setAttribute("username", username);
                return "redirect:/";
            } else {
                return "redirect:/api/error?message=Password%20errata";
            }

        } else {
            return "redirect:/api/error?message=Nessun%20utente%20trovato";
        }

    }

    @PostMapping("/api/register")
    public String apiRegister(@RequestParam String username, @RequestParam String password, HttpSession session) throws NoSuchAlgorithmException {
        if(username.length() > 45)
            return "redirect:/api/error?message=NomeUtenteTroppoLungo";

        // PROCESSO DI REGISTRAZIONE QUI
        if (!utenteService.loadByUsername(username).isPresent()) {

            String encryptedPassword = encrypt(password);

            if(encryptedPassword.length() > 255)
                return "redirect:/api/error?message=PasswordTroppoLungaDaCriptare";

            Utente utente = new Utente(username, encryptedPassword);
            utenteService.registraUtente(utente);

            session.setAttribute("username", username);
            return "redirect:/";

        } else {
            return "redirect:/api/error?message=UtenteEsistente";
        }
    }

    @RequestMapping("/api/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    private static String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest encrypter = MessageDigest.getInstance("MD5");
        encrypter.update(password.getBytes());
        byte[] bytes = encrypter.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return sb.toString();
    }


}
