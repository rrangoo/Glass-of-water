package com.glassofwater.gow.service;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.models.UserInfo;
import com.glassofwater.gow.repository.UserInfoRepo;
import com.glassofwater.gow.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {
    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MailService mailService;


    public void create(String email){
        String code = Integer.toString(new Random().nextInt(9000) + 1000);
        UserInfo tmp = new UserInfo();

        tmp.setEmail(email);
        tmp.setCode(code);

        if (mailService.sendMessage(email, code)){
            userInfoRepo.save(tmp);
        }
    }

    public User confirm(UserInfo userInfo){
        UserInfo currentUserInfo = userInfoRepo.getByEmail(userInfo.getEmail());

        if (currentUserInfo == null){
            return null;
        }

        if (currentUserInfo.getCode().equals(userInfo.getCode())){
            User user = userRepo.findByEmail(userInfo.getEmail());

            if (user == null){
                user = new User();
                user.setEmail(userInfo.getEmail());
                userRepo.save(user);
            }

            userInfoRepo.delete(currentUserInfo);

            return user;
        } else {
            return null;
        }
    }
}
