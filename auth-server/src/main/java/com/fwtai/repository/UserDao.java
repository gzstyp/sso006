package com.fwtai.repository;

import com.fwtai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long>{

    User findUserByUsername(String username);
}