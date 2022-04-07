package com.glassofwater.gow.service.repositories.user.register;

import com.glassofwater.gow.models.User;

public interface UserRepoRegister {
    User getUserByEmail(String email);
    boolean contains(String email);
}
