package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public interface UserService {
    List<User> findAll();

    int addUser(String nickname, String email, String password, Timestamp registrationTime);

    boolean updateImage(Integer userId, MultipartFile file) throws IOException;

    User findById(Integer userId);

    User findByEmail(String email);

    int deleteUser(String email);
}
