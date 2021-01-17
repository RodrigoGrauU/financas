package com.sistemas.financas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/despesa")
public class DespesaController {

    ModelAndView modelAndView;

    public DespesaController() {
        this.modelAndView = new ModelAndView();
    }

    @GetMapping(path ="/adicionar")
    public ModelAndView adicionarDespesa() {
        modelAndView.setViewName("/despesa/adicionar-despesa");
        return modelAndView;
    }
}
