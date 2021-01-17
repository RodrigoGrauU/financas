package com.sistemas.financas.rest;

import com.sistemas.financas.model.Transacao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/despesa")
public class DespesaResource {

    @CrossOrigin //habilita consumo de recurso de forma global
    @PostMapping(path = "adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao adicionarDespesa(@RequestBody Transacao despesa) {
        return despesa;
    }
}
