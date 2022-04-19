package com.glassofwater.gow.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    String message = "";

    @GetMapping
    public String getMessage(){
        return message;
    }

    @PostMapping
    public void setMessage(@RequestBody String message){
        this.message = message;
    }
}
