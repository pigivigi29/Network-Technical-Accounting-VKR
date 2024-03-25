package com.example.dl_spring.controller;

import com.example.dl_spring.dto.AuthorizedUserDto;
import com.example.dl_spring.service.AuthService;
import com.example.dl_spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthorizedUserDto authorizedUserDto) {
        return authService.createAuthToken(authorizedUserDto);
    }

}
