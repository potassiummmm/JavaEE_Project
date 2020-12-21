package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.*;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.service.BlogService;
import com.tongji.springbootdemo.service.impl.BlogServiceImpl;
import com.tongji.springbootdemo.service.impl.UserServiceImpl;
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
    private UserServiceImpl userService;
    @Autowired
    private BlogServiceImpl blogService;

    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session){
        if (userService.findByEmail(email).isEmpty()) {
            model.addAttribute("loginMsg", "The user does not exist!");
            return "login";
        }
        else if (!userService.findByEmail(email).isEmpty() && userService.findByEmail(email).get(0).getPassword().equals(password)) {
            List<Blog> blogs = blogService.findAll();
            model.addAttribute("blogs", blogs);
            session.setAttribute("userEmail",email);
            session.setAttribute("currentUser",userService.findByEmail(email).get(0).getNickname());
            return "index";
        }
        else {
            model.addAttribute("loginMsg", "Wrong email address or password!");
            return "login";
        }
    }
}
