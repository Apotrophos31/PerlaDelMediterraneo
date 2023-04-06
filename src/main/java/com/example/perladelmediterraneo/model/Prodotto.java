package com.example.perladelmediterraneo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "prodotti")
@Getter
@Setter
public class Prodotto {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "prezzo_kg")
    private double prezzo_kg;

    @Column(name = "quantita")
    private int quantita;

    @Column(name = "arrivo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivo;

    @Column(name = "scadenza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scadenza;

}
