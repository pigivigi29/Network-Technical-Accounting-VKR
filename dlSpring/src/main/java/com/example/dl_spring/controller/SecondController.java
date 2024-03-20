package com.example.dl_spring.controller;

import com.example.dl_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {
    private final UserService service;

    @Autowired
    public SecondController(UserService service) {
        this.service = service;
    }



}
