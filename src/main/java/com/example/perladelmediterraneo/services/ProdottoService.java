package com.example.perladelmediterraneo.services;

import com.example.perladelmediterraneo.model.Prodotto;
import com.example.perladelmediterraneo.repositories.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    private ProdottoRepository prodottiRepository;

    public List<Prodotto> getListaProdotti() {
        return prodottiRepository.findAll();
    }

    public void aggiungiProdotto(String nome, double prezzo_kg, int quantita) {
        Prodotto prodotti = new Prodotto();

        prodotti.setNome(nome);
        prodotti.setPrezzo_kg(prezzo_kg);
        prodotti.setQuantita(quantita);

        Calendar oggi = Calendar.getInstance();
        prodotti.setArrivo(oggi.getTime());

        oggi.add(Calendar.DAY_OF_MONTH, 1);
        prodotti.setScadenza(oggi.getTime());

        prodottiRepository.save(prodotti);
    }

    public void rimuoviProdotto(int id) {
        Optional<Prodotto> daRimuovere = prodottiRepository.findById(id);

        if (daRimuovere.isPresent())
            prodottiRepository.delete(daRimuovere.get());
    }

}
