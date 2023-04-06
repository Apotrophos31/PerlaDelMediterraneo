package com.example.perladelmediterraneo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
public class Utente {

    public static final String RUOLO_UTENTE = "USER";
    public static final String RUOLO_ADMIN = "ADMIN";

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "ruolo")
    private String ruolo;

    public Utente() {
    }

    public Utente(String username, String password) {
        this.username = username;
        this.password = password;
        this.ruolo = RUOLO_UTENTE;
    }
}
