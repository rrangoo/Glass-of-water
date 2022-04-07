package com.glassofwater.gow.repository;

import com.glassofwater.gow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users " +
            "WHERE email = :email",
            nativeQuery = true)
    User getByEmail(@Param("email") String email);

}
