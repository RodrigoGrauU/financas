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
        return userRepository.save(u);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
