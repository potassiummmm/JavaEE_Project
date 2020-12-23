package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.*;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.service.BlogService;
import com.tongji.springbootdemo.service.LikeService;
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
    
    @Autowired
    private LikeService likeService;

    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("hiddenPassword") String password, Model model, HttpSession session){

        if (userService.findByEmail(email) == null) {
            model.addAttribute("loginMsg", "The user does not exist!");
            return "login";
        }
        else if (userService.findByEmail(email) != null && userService.findByEmail(email).getPassword().equals(password)) {
            List<Blog> blogs = blogService.findByMostRecent();
            session.setAttribute("userEmail",email);
            session.setAttribute("currentUser",userService.findByEmail(email).getNickname());
            session.setAttribute("userId", userService.findByEmail(email).getUserId());
            for (int i=0;i<blogs.size();i++){
                if((likeService.findById((Integer) session.getAttribute("userId"),
                        blogs.get(i).getBlogId())).isEmpty()==false)
                {
                    blogs.get(i).setIsLike(true);
                }
                else
                    blogs.get(i).setIsLike(false);
            }
            model.addAttribute("blogs", blogs);
            return "index";
        }
        else {
            model.addAttribute("loginMsg", "Wrong email address or password!");
            return "login";
        }
    }
}
