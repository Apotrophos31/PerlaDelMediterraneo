package com.example.perladelmediterraneo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "prodotti")
@Getter
@Setter
public class Prodotti {
    @Id
    private int id;
    private String nome;
    private double prezzo_kg;
    private int quantita;
    private Date arrivo;
    private Date scadenza;

}
