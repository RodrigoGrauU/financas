package com.sistemas.financas.rest;

import com.sistemas.financas.model.Transacao;
import com.sistemas.financas.services.transacao.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/transacao")
public class TransacaoResource {
    @Autowired
    private TransacaoService transacaoService;

    @CrossOrigin //habilita consumo de recurso de forma global
    @PostMapping(path = "adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao adicionarDespesa(@RequestBody Transacao despesa) {
        return transacaoService.save(despesa);
    }

    @CrossOrigin //habilita consumo de recurso de forma global
    @DeleteMapping(path = "remover")
    @ResponseStatus(HttpStatus.OK)
    public void removerDespesa(@RequestBody Transacao despesa) {
        transacaoService.delete(despesa.getId());
    }
}
