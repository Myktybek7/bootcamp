package com.example.demo.controller;


import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String name(@RequestParam String name){
        return name+ " hello!";
    }
    @PostMapping("/register")
    public String register(@RequestParam(required = false) String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return name+ " registered!";
    }
    @GetMapping("/getAll")
    public List<User> users(){
        return userRepository.findAll();
    }
    @GetMapping("/login")
    public boolean login(@RequestParam String username,@RequestParam int password){
        System.out.println("Entered data: " + username + " " + password);
        return(true);
    }

}
