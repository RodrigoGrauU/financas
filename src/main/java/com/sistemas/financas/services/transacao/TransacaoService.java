package com.sistemas.financas.services.transacao;

import com.sistemas.financas.model.Transacao;
import com.sistemas.financas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao save(Transacao t) {
        return transacaoRepository.save(t);
    }

    public void delete(int id) {
        transacaoRepository.deleteById(id);
    }

    public Transacao update(int id, Transacao transacaoUpdate ) {
        transacaoUpdate.setIdConta(1); //valor temporário até que se faça a parte para salvar a informação por conta
        Optional<Transacao> transacaoEntity = transacaoRepository.findById(id);
        final Transacao transacao;

        if (transacaoEntity.isPresent()) {
            transacao =transacaoEntity.get();
        } else {
            throw new RuntimeException();
        }

        transacao.setIdConta(transacaoUpdate.getIdConta());
        transacao.setDataTransacao(transacaoUpdate.getDataTransacao());
        transacao.setDescricaoTransacao(transacaoUpdate.getDescricaoTransacao());
        transacao.setValorTransacao(transacaoUpdate.getValorTransacao());
        transacao.setTipo(transacaoUpdate.getTipo());

        return transacaoRepository.save(transacao);
    }
}
