package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

import java.sql.Timestamp;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/user/register")
    public String login(@RequestParam("nickname") String nickname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model, HttpSession session){
        if(StringUtils.isEmpty(nickname) || StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(confirmPassword)){
            model.addAttribute("registerMsg","Please enter your nick name, e-mail address and password!");
            return "register";
        }
        else if(!password.equals(confirmPassword)){
            model.addAttribute("registerMsg", "The two passwords are different, please check again!");
            return "register";
        }
        else if(userService.findByEmail(email) != null){
            model.addAttribute("registerMsg", "The email is already taken, please log in or check again!");
            return "register";
        }
        else{
            userService.addUser(nickname,email,password,new Timestamp(System.currentTimeMillis()));
            model.addAttribute("successMsg", "Register successfully! Please login!");
            return "login";
        }
    }
}
