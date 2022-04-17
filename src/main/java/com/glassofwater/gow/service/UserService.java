package com.glassofwater.gow.service;

import com.glassofwater.gow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;
}
