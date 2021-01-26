package com.sistemas.financas.services.transacao;

import com.sistemas.financas.model.Transacao;
import com.sistemas.financas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao save(Transacao t) {
        //setando conta para unico usuário - ação temporária
        t.setIdConta(1);
        return transacaoRepository.save(t);
    }

    public void delete(int id) {
        transacaoRepository.deleteById(id);
    }
}
