package com.example.controller;

import com.example.commons.exceptions.UnknownResourceException;
import com.example.commons.service.GenericService;
import com.example.model.Product;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    private GenericService<User> service;
    @Autowired
    public UserController() {
        service = new GenericService<>("mongo",User.class);
//        service = new GenericService<>("mysql",User.class);
    }

    @PostMapping
    public User create(@RequestBody User user) throws UnknownResourceException {
        return service.update(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable String id) throws UnknownResourceException {
        return service.findById(id);
    }
}