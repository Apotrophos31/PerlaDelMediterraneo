package com.example.perladelmediterraneo.services;

import com.example.perladelmediterraneo.model.Utente;
import com.example.perladelmediterraneo.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    public Optional<Utente> loadByUsername(String username){
        return utenteRepository.findUtenteByUsername(username);
    }

    public void registraUtente(Utente utente){
        utenteRepository.save(utente);
    }

}
