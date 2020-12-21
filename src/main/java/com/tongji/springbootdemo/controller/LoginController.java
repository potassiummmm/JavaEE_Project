package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.*;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BlogMapper blogMapper;

    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session){
        List<User> users = userMapper.findByEmail(email);
        if (users.isEmpty()) {
            model.addAttribute("loginMsg", "The user does not exist!");
            return "login";
        }
        else if (!users.isEmpty() && userMapper.findByEmail(email).get(0).getPassword().equals(password)) {
            List<Blog> blogs = blogMapper.findAll();
            model.addAttribute("blogs", blogs);
            session.setAttribute("userEmail",email);
            session.setAttribute("currentUser",users.get(0).getNickname());
            session.setAttribute("userId", users.get(0).getUserId());
            return "index";
        }
        else {
            model.addAttribute("loginMsg", "Wrong email address or password!");
            return "login";
        }
    }
}
