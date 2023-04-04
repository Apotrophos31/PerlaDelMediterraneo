package com.example.perladelmediterraneo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="utenti")
@Getter
@Setter
public class Utenti {

    public static int RUOLO_DEFAULT = 0;
    public static int RUOLO_ADMIN = 1;

    @Id
    @GeneratedValue
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="ruolo")
    private int ruolo;
}
