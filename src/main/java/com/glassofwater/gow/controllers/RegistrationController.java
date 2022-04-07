package com.glassofwater.gow.controllers;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.service.repositories.user.register.UserRepoRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepoRegister userRepoRegister;

    @Autowired
    public RegistrationController(UserRepoRegister userService) {
        this.userRepoRegister = userService;
    }

    @GetMapping(value = "/{user-email}")
    public @ResponseBody ResponseEntity<User> sendSimpleEmail(@PathVariable("user-email") String email) {
        User currentUser;
        try {
            if (userRepoRegister.contains(email)){
                currentUser = userRepoRegister.getUserByEmail(email);

                // Login.
            } else {
                // Register new user.


                return new ResponseEntity<>();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

}
