package com.tongji.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @RequestMapping("/user/register")
    public String login(@RequestParam("nickName") String nickName, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model, HttpSession session){
        if(StringUtils.isEmpty(nickName) || StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(confirmPassword)){
            //TODO: check whether this email has been used
//            session.setAttribute("loginUser", email);
//            add to database
            model.addAttribute("registerMsg","Please enter your nick name, e-mail address and password!");
            return "register";
        }
        if(!password.equals(confirmPassword)){
            model.addAttribute("registerMsg", "The two passwords are different, please check again!");
            return "register";
        }
        model.addAttribute("successMsg", "Register successfully! Please login!");
        return "login2";
    }
}
