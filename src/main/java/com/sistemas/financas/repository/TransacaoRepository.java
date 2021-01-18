package com.sistemas.financas.repository;

import com.sistemas.financas.model.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao,Integer> {
}
