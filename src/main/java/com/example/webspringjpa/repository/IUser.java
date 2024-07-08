package com.example.webspringjpa.repository;

import com.example.webspringjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
