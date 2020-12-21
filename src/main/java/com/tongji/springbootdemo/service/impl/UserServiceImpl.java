package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.mapper.UserMapper;
import com.tongji.springbootdemo.model.User;
import com.tongji.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public int addUser(String nickname, String email, String password, Date registrationTime) {
        return userMapper.addUser(nickname, email, password, registrationTime);
    }

    public List<User> findById(Integer userId) {
        return userMapper.findById(userId);
    }

    public List<User> findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public int deleteUser(String email) {
        return userMapper.deleteUser(email);
    }
}
