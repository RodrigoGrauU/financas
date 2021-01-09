package com.sistemas.financas.controller;

import com.sistemas.financas.repository.UserRepository;
import com.sistemas.financas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/usuario")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = {"/", ""})
    public @ResponseBody String metodo1 () {
        return "<html><head></head><body>" +
                "<h1>Olá</h1>" +
                "<a href=" + '"' + "/usuario/todos" + '"' + ">Listar Usuários</a><br/>" +
                "<a href=\"/usuario/add\" >Adicionar Novo Usuário</a>" +
                "</body></html>" ;
    }

    @GetMapping(path = "/add")
    @ResponseBody
    public String adicionarUsuario() {
        return "<html>" +
                "<body>" +
                "<h1>Adicionar Usuário</h1>" +
                "<form method=" + '"' + "post" + '"' + ">" +
                "<input name=" + '"' + "name" + '"' + " /><br/>" +
                "<input name=" + '"' + "email" + '"' + " /><br/>" +
                "<button type=" + '"' + "submit" + '"' + ">Enviar</button>" +
                "</form>" +
                "</body>" +
        "</html>";
    }



    /*@GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }*/

    @GetMapping("/todos")
    public ModelAndView messages() {
        ModelAndView modelAndView = new ModelAndView("/usuario/todos");
        modelAndView.addObject("usuarios", userRepository.findAll());
        return modelAndView;
    }
    @PostMapping(path = "/add")
    public String addNewUser (@RequestParam String name, @RequestParam String email) {
        Usuario u = new Usuario();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);
        return "redirect:/usuario/todos";
    }
}
