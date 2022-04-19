package com.glassofwater.gow.repository;

import com.glassofwater.gow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
