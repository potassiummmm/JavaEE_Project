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
    private static final String defaultImage = "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";


    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/user/register")
    public String login(@RequestParam("nickname") String nickname, @RequestParam("email") String email, @RequestParam("hiddenPassword") String password, @RequestParam("hiddenConfirmPassword") String confirmPassword, Model model, HttpSession session) throws Exception {
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
            userService.updateImageByString(userService.findByEmail(email).getUserId(), defaultImage);
            model.addAttribute("successMsg", "Register successfully! Please login!");
            return "login";
        }
    }
}
