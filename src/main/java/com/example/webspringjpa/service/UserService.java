package com.example.webspringjpa.service;


import com.example.webspringjpa.entity.User;
import com.example.webspringjpa.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUser iUser;
    public User findByUsernameAndPassword(String username, String password) {
        return iUser.findByUsernameAndPassword(username, password);
    }
}
