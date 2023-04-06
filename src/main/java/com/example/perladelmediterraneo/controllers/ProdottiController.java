package com.example.perladelmediterraneo.controllers;

import com.example.perladelmediterraneo.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdottiController {

    @Autowired
    private ProdottoService prodottiService;

    @RequestMapping("/prodotti")
    public void listaProdotti(Model model) {
        model.addAttribute("lista_prodotti", prodottiService.getListaProdotti());
    }

    @PostMapping("/api/aggPrd")
    public String aggiungiProdotti(
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "prezzo_kg") double prezzo_kg,
            @RequestParam(name = "quantita") int quantita
    ) {
        prodottiService.aggiungiProdotto(nome, prezzo_kg, quantita);
        return "redirect:/prodotti";
    }

    @PostMapping("/api/rmvPrd")
    public String rimuoviProdotti(@RequestParam(name = "id") int id) {
        prodottiService.rimuoviProdotto(id);
        return "redirect:/prodotti";
    }

}
