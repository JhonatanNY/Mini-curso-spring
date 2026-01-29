package com.example.curso.springboot.webapp.springboot_web.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.curso.springboot.webapp.springboot_web.model.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Marcelo","Yataco");


        user.setEmail("Jhonatan@gmail.com");
        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);
        

        return "details";
    }

    
    @GetMapping("/list")
    public String list(Model model){

        // model.addAttribute("users", users);
        model.addAttribute("title", "Lista de usuarios");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
        
        List<User> users2 = Arrays.asList(new User("Pedro","Suarez"),
        new User("Robert","Plant","Robert@gmail.com"),
        new User("Micky","Gonzales"));
        return users2;

    }

}
