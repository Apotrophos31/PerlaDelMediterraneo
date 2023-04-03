package com.example.perladelmediterraneo.controllers;

import com.example.perladelmediterraneo.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProdottiController {

    @Autowired
    private ProdottiService prodottiService;

    @RequestMapping("/prodotti/lista")
    public void listaProdotti(Model model) {
        model.addAttribute("lista_prodotti", prodottiService.getProdotti());
    }

    @PostMapping("/prodotti/aggiungi")
    public String aggiungiProdotti(
            @RequestParam(name = "nome") String nome,
            @RequestParam(name = "prezzo_kg") double prezzo_kg,
            @RequestParam(name = "quantita") int quantita
            ) {
        prodottiService.addProdotti(nome, prezzo_kg, quantita);
        return "redirect:/prodotti/lista";
    }

    @PostMapping("/prodotti/rimuovi")
    public String rimuoviProdotti(@RequestParam(name="id") int id){
        prodottiService.rimuoviProdotti(id);
        return "redirect:/prodotti/lista";
    }

}
