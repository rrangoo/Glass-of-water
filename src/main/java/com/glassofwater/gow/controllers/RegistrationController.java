package com.glassofwater.gow.controllers;

import com.glassofwater.gow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/greet")
    public String addUser() {
        return "HELLO";
    }
}
