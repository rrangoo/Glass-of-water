package com.glassofwater.gow.service;

import com.glassofwater.gow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulerService {

    private final UserRepositoryService userService;

    private final EmailService emailService;

    @Autowired
    public SchedulerService(UserRepositoryService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @Scheduled
    public void sendMailToUsers(){
        List<User> list = userService.getAll();
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