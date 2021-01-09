package com.sistemas.financas.services.usuario;

import com.sistemas.financas.repository.UserRepository;
import com.sistemas.financas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Usuario save(Usuario u) {
        System.out.println("Utiliza a regra de nogócio e salva o usuário no banco ");
        return userRepository.save(u);
    }
}
