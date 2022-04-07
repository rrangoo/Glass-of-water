package com.glassofwater.gow.service.repositories.user.register;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepoRegisterService implements UserRepoRegister {

    private final UserRepository repository;

    @Autowired
    public UserRepoRegisterService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public boolean contains(String email) {
        return repository.getByEmail(email) != null;
    }
}