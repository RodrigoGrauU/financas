package com.sistemas.financas.controller;

import com.sistemas.financas.model.Usuario;
import com.sistemas.financas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GreetingController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/add-user")
    public String formularioAddUser() {
        return "add-user";
    }
    @PostMapping("/user")
    public String createUser(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(usuario);
        redirect.addFlashAttribute("message", "Usuário" + usuario.getName() + "criado com sucesso!");

        return "redirect:users";
    }

    @GetMapping("/users")
    public String listaUsuariosPagina() {
        return "users";
    }

    @PostMapping(path = "add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        Usuario u = new Usuario();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
