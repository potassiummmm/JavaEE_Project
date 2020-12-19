package com.tongji.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping("/about")
    public String about(Model model, HttpSession session) {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(Model model, HttpSession session) { return "contact"; }
}
