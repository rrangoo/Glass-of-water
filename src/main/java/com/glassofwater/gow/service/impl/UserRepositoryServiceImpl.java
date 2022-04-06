package com.glassofwater.gow.service.impl;

import com.glassofwater.gow.models.User;
import com.glassofwater.gow.repository.UserRepository;
import com.glassofwater.gow.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository repository;

    @Autowired
    public UserRepositoryServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAllNotNullMail();
    }
}