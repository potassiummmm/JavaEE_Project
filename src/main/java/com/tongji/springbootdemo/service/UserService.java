package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface UserService {
    List<User> findAll();

    int addUser(String nickname, String email, String password, Timestamp registrationTime);

    User findById(Integer userId);

    User findByEmail(String email);

    int deleteUser(String email);
}
