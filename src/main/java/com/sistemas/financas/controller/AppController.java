package com.sistemas.financas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe controller mais genérica para a aplicação
 */

@Controller
public class AppController {
    @RequestMapping(path = {"", "/", "home"})
    public String home() {
        return "home";
    }
}
