package com.example.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.springboot.webapp.springboot_web.model.User;
import com.example.curso.springboot.webapp.springboot_web.model.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details2")
    public UserDto details(){

        UserDto userDto = new UserDto();
        User user = new User("Jhon","nuñez");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring Boot");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        
        User user1 = new User("Jhon","nuñez");
        User user2 = new User("Pepe","madrid");
        User user3 = new User("marcelo","yataco");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

    @GetMapping("/details2-map")
    public Map<String, Object> detailsMap(){

        User user = new User("Jhonatan","nuñez");
        
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo Spring Boot");
        body.put("user",user);

        return body;
    }

}
