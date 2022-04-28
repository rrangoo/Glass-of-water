package com.glassofwater.gow.service;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.models.UserInfo;
import com.glassofwater.gow.repository.UserInfoRepo;
import com.glassofwater.gow.repository.UserRepo;
import com.glassofwater.gow.util.AuthStatus;
import com.glassofwater.gow.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthService {
    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MailService mailService;


    /**
     * @param email Адрес почты пользователя.
     * @return "success" - если сообщение с кодом удолось отправить на данный адрес.
     */
    public Status create(String email){
        String code = Integer.toString(new Random().nextInt(9000) + 1000);
        UserInfo tmp = new UserInfo();

        tmp.setEmail(email);
        tmp.setCode(code);

        if (mailService.sendMessage(email, code)){
            UserInfo currentUserInfo = userInfoRepo.getByEmail(email);
            if (currentUserInfo != null){
                userInfoRepo.delete(currentUserInfo);
            }
            userInfoRepo.save(tmp);
            return new Status("success");
        } else {
            return new Status("failed");
        }
    }

//    public User confirm(UserInfo userInfo){
//        UserInfo currentUserInfo = userInfoRepo.getByEmail(userInfo.getEmail());
//
//        if (currentUserInfo == null){
//            return null;
//        }
//
//        if (currentUserInfo.getCode().equals(userInfo.getCode())){
//            User user = userRepo.findByEmail(userInfo.getEmail());
//
//            if (user == null){
//                user = new User();
//                user.setEmail(userInfo.getEmail());
//                userRepo.save(user);
//            }
//
//            userInfoRepo.delete(currentUserInfo);
//
//            return user;
//        } else {
//            return null;
//        }
//    }

    public Pair<AuthStatus, User> confirm(UserInfo userInfo){
        UserInfo currentUserInfo = userInfoRepo.getByEmail(userInfo.getEmail());

        if (currentUserInfo == null){
            return new Pair<>(AuthStatus.failed, null);
        }

        if (currentUserInfo.getCode().equals(userInfo.getCode())){
            User user = userRepo.findByEmail(userInfo.getEmail());

            if (user == null){
                user = new User();
                user.setEmail(userInfo.getEmail());
                user.setRate(0);
                user.setUsername(user.getEmail().split("@")[0]);
                user.setFriends(new ArrayList<>());
                userRepo.save(user);
            }

            userInfoRepo.delete(currentUserInfo);

            return new Pair<>(AuthStatus.success, user);
        } else {
            return new Pair<>(AuthStatus.failed, null);
        }
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public List<UserInfo> getUsersInfo(){
        return userInfoRepo.findAll();
    }

    public void delete(UserInfo userInfo){
        userInfoRepo.delete(userInfo);
    }
}
