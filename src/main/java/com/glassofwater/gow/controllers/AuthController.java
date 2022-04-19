package com.glassofwater.gow.controllers;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.models.UserInfo;
import com.glassofwater.gow.service.AuthService;
import com.glassofwater.gow.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    AuthService authService;

    public AuthController(@Autowired AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("users")
    public List<User> getUsers(){
        return authService.getUsers();
    }

    @GetMapping("infos")
    public List<UserInfo> getUsersInfo(){
        return authService.getUsersInfo();
    }

    @PostMapping("/email")
    public ResponseEntity<String> createUserInfo(@RequestBody Email email) {

        try {
            authService.create(email.getEmail());
        } catch (MailException e) {
            return ResponseEntity.ok("Email not found!");
        }

        return ResponseEntity.ok("Email sent!");
    }

    @PostMapping("/code")
    public ResponseEntity<User> auth(@RequestBody UserInfo userInfo) {
        User newUser = authService.confirm(userInfo);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UserInfo userInfo){
        authService.delete(userInfo);
    }
}
