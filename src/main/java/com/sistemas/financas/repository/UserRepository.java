package com.sistemas.financas.repository;

import com.sistemas.financas.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario, Integer> {
}