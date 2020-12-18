package com.tongji.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session){
        if(!StringUtils.isEmpty(email) && !StringUtils.isEmpty(password)){
            session.setAttribute("loginUser", email);
            return "index";
        }
        model.addAttribute("msg","Wrong username/email or password!");
        return "login2";
    }
}
