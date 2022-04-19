package com.glassofwater.gow.service;

import com.glassofwater.gow.models.UserInfo;
import com.glassofwater.gow.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    UserInfoRepo userInfoRepo;

    public AuthService(@Autowired UserInfoRepo userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

    public void create(String email){
        int code = new Random().nextInt(9000) + 1000;
        UserInfo tmp = new UserInfo();

        tmp.setEmail(email);
        tmp.setCode(Integer.toString(code));

        userInfoRepo.save(tmp);
    }
}
