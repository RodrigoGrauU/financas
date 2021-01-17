package com.sistemas.financas.repository;

import com.sistemas.financas.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface DespesaRepository extends CrudRepository<Usuario,Integer> {
}
