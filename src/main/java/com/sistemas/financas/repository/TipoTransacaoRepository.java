package com.sistemas.financas.repository;

import com.sistemas.financas.model.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Integer> {
}
