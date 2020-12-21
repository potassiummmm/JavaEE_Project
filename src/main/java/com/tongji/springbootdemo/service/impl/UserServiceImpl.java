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

    public User findById(Integer userId) {
        if (userMapper.findById(userId).isEmpty()) {
            return null;
        }
        return userMapper.findById(userId).get(0);
    }

    public User findByEmail(String email) {
        if (userMapper.findByEmail(email).isEmpty()) {
            return null;
        }
        return userMapper.findByEmail(email).get(0);
    }

    public int deleteUser(String email) {
        return userMapper.deleteUser(email);
    }
}
