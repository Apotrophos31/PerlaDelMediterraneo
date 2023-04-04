package com.example.perladelmediterraneo.services;

import com.example.perladelmediterraneo.model.Utenti;
import com.example.perladelmediterraneo.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtentiService {

    @Autowired
    UtentiRepository utentiRepository;

    public enum LoginResponse {NESSUN_UTENTE_TROVATO, PASSWORD_SBAGLIATA, SUCCESSO}

    public LoginResponse validateLogin(String username, String password) {
        List<Utenti> utenti = utentiRepository.getUtenteByUsernameLike(username);

        if (utenti.size() == 0)
            return LoginResponse.NESSUN_UTENTE_TROVATO;
        else if (utenti.get(0).getPassword().equals(password))
            return LoginResponse.SUCCESSO;
        else
            return LoginResponse.PASSWORD_SBAGLIATA;
    }

}
