package com.sistemas.financas.rest;

import com.sistemas.financas.model.Transacao;
import com.sistemas.financas.services.usuario.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/transacao/despesa")
public class DespesaResource {
    @Autowired
    private TransacaoService transacaoService;

    @CrossOrigin //habilita consumo de recurso de forma global
    @PostMapping(path = "adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao adicionarDespesa(@RequestBody Transacao despesa) {
        return transacaoService.save(despesa);
    }
}
