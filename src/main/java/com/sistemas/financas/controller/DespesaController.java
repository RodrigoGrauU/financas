package com.sistemas.financas.controller;

import com.sistemas.financas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/despesa")
public class DespesaController {

    ModelAndView modelAndView;

    @Autowired
    TransacaoRepository despesas;

    public DespesaController() {
        this.modelAndView = new ModelAndView();
    }

    @GetMapping(path ="/adicionar")
    public ModelAndView adicionarDespesa() {
        modelAndView.setViewName("/despesa/adicionar-despesa");
        return modelAndView;
    }

    @GetMapping(path = {"", "/"})
    public ModelAndView despesas() {
        modelAndView.setViewName("/despesa/despesas");
        modelAndView.addObject("despesas",despesas.findAll());
        return modelAndView;
    }
}
