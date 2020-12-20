package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.UserMapper;
import com.tongji.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/userList")
    public String getUserList(Model model) {
        List<User> users=userMapper.findAll();
        model.addAttribute("users",users);
        return "userList";
    }
}
