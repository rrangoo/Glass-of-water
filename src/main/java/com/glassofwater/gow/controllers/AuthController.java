package com.glassofwater.gow.controllers;

import com.glassofwater.gow.models.Email;
import com.glassofwater.gow.models.User;
import com.glassofwater.gow.models.UserInfo;
import com.glassofwater.gow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Boolean> createUserInfo(@RequestBody Email email) {
        return ResponseEntity.ok(authService.create(email.getEmail()));
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
