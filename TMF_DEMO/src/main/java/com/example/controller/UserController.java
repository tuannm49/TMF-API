package com.example.controller;

import com.example.model.User;
import com.example.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final GenericService<User> userService;

    @Autowired
    public UserController(@Qualifier("userService") GenericService<User> userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestParam String id, @RequestParam String name) {
        User userDTO = new User();
        userDTO.setId(id);
        userDTO.setName(name);
        return userService.save(id, userDTO);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findById(id);
    }
}