package com.glassofwater.gow.controllers;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") User user){
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user){


        return userRepo.save(user);
    }

    @PutMapping("{id}")
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User user
    ){
        BeanUtils.copyProperties(user, userFromDb, "id");
        return userRepo.save(userFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User user){
        userRepo.delete(user);
    }
}
