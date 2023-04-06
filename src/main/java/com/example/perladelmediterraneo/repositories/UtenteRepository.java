package com.example.perladelmediterraneo.repositories;

import com.example.perladelmediterraneo.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {

    Optional<Utente> findUtenteByUsername(String username);

}
