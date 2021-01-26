package com.sistemas.financas.controller;

import com.sistemas.financas.repository.TipoTransacaoRepository;
import com.sistemas.financas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/transacao")
public class TransacaoController {

    ModelAndView modelAndView;

    @Autowired
    TransacaoRepository transacao;

    @Autowired
    TipoTransacaoRepository tipoTransacaoRepository;

    public TransacaoController() {
        this.modelAndView = new ModelAndView();
    }

    @GetMapping(path ="/adicionar")
    public ModelAndView adicionarTransacao() {
        modelAndView.addObject("tiposTransacoes", tipoTransacaoRepository.findAll());
        modelAndView.setViewName("/transacao/adiciona-transacao");
        return modelAndView;
    }

    @GetMapping(path = {"", "/"})
    public ModelAndView transacoes() {
        modelAndView.setViewName("/transacao/transacoes");
        modelAndView.addObject("transacoes", transacao.findAll());
        return modelAndView;
    }
}
