package com.example.perladelmediterraneo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @Autowired
    HttpSession session;

    @RequestMapping("/")
    public String index(HttpSession session) {
        if(session.getAttribute("username") == null)
            session.setAttribute("username", "");

        return "index";
    }

    @RequestMapping("/chisiamo")
    public String chisiamo() {
        return "chisiamo";
    }

    @RequestMapping("/contatti")
    public String contatti() {
        return "contatti";
    }

}
