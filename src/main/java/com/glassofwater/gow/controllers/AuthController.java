package com.glassofwater.gow.controllers;

import com.glassofwater.gow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    AuthService authService;

    public AuthController(@Autowired AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/email")
    public String createUserInfo(@RequestBody String email){
        authService.create(email);
        return "good";
    }

    @PostMapping("/code")
    public String auth(@RequestBody String code){

        return "good";
    }
}
