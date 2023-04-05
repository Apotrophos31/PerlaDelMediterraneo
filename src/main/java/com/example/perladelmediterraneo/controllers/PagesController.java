package com.example.perladelmediterraneo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/chisiamo")
    public String chisiamo(){return "chisiamo";}

    @RequestMapping("/contatti")
    public String contatti(){return "contatti";}

}
