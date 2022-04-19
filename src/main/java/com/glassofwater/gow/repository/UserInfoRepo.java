package com.glassofwater.gow.repository;

import com.glassofwater.gow.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
}
