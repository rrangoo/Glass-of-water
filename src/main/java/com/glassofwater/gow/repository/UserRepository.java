package com.glassofwater.gow.repository;

import com.glassofwater.gow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
