package com.glassofwater.gow.service;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.service.email.EmailRegister;
import com.glassofwater.gow.service.repositories.user.register.UserRepoRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    private final UserRepoRegister userService;

    private final EmailRegister emailService;

    @Autowired
    public SchedulerService(UserRepoRegister userService, EmailRegister emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    //@Scheduled
    public void sendMailToUsers(){
        List<User> list = null;
        if (!list.isEmpty()) {
            list.forEach(user -> {
                try {
                    emailService.send(user.getEmail(), "Registration", "Code");
                } catch (Exception e) {
                }
            });
        }
    }
}