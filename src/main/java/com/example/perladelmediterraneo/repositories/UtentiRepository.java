package com.example.perladelmediterraneo.repositories;

import com.example.perladelmediterraneo.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtentiRepository extends JpaRepository<Utenti, Integer> {

    List<Utenti> getUtenteByUsernameLike(String username);

}
