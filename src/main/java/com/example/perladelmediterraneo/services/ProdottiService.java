package com.example.perladelmediterraneo.services;

import com.example.perladelmediterraneo.model.Prodotti;
import com.example.perladelmediterraneo.repositories.ProdottiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProdottiService {

    @Autowired
    private ProdottiRepository prodottiRepository;

    public List<Prodotti> getProdotti() {
        return prodottiRepository.findAll();
    }

    public void addProdotti(String nome, double prezzo_kg, int quantita){
        Prodotti prodotti = new Prodotti();

        prodotti.setNome(nome);
        prodotti.setPrezzo_kg(prezzo_kg);
        prodotti.setQuantita(quantita);

        Calendar oggi = Calendar.getInstance();
        prodotti.setArrivo(oggi.getTime());

        oggi.add(Calendar.DAY_OF_MONTH, 1);
        prodotti.setScadenza(oggi.getTime());

        prodottiRepository.save(prodotti);
    }

    public void rimuoviProdotti(int id){
        Optional<Prodotti> daRimuovere = prodottiRepository.findById(id);

        if(daRimuovere.isPresent())
            prodottiRepository.delete(daRimuovere.get());
    }

}
