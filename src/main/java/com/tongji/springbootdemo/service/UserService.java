package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.User;

import java.sql.Date;
import java.util.List;

public interface UserService {
    List<User> findAll();

    int addUser(String nickname, String email, String password, Date registrationTime);

    List<User> findById(Integer userId);

    List<User> findByEmail(String email);

    int deleteUser(String email);
}
