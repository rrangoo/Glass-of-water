package com.glassofwater.gow.repository;

import com.glassofwater.gow.models.Trip;
import com.glassofwater.gow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
