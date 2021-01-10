package com.sistemas.financas.rest;

import com.sistemas.financas.model.Usuario;
import com.sistemas.financas.services.usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    //Recebe usuario para ser inserido a partir de um JSON e retorna o status de CRIADO
    @PostMapping(path = "/api/usuario/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario addNewUser(@RequestBody Usuario usuario) {
        return userService.save(usuario);
    }

    @PostMapping(path = "/api/usuario/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@RequestBody Usuario usuario) {
        userService.deleteById(usuario.getId());
    }
}
