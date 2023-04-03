package com.example.perladelmediterraneo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdottiController {

    @GetMapping("/prodotti")
    public String prodotti(@RequestParam(name = "test", required = false, defaultValue = "TEST DEFAULT") String test, Model model) {
        model.addAttribute("test", test);
        return "/prodotti";
    }

}
