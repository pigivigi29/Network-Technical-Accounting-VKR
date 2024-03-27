package com.example.dl_spring.controller;

import com.example.dl_spring.dto.AuthorizedUserDto;
import com.example.dl_spring.model.User;
import com.example.dl_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    private final UserService service;


    @Autowired
    public MainController(UserService service) {
        this.service = service;
    }


    @GetMapping("/page/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = service.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/page")
    public ResponseEntity<User> newUser(@RequestBody AuthorizedUserDto userDto) {
        User user = service.saveUser(userDto);
        System.out.println(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}