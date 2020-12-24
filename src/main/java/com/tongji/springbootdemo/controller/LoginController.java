package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.*;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.service.BlogService;
import com.tongji.springbootdemo.service.LikeService;
import com.tongji.springbootdemo.service.StarService;
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
    
    @Autowired
    private StarService starService;

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
            for (Blog blog : blogs) {
                if (!(likeService.findById((Integer) session.getAttribute("userId"),
                        blog.getBlogId())).isEmpty()) {
                    blog.setIsLike(true);
                } else
                    blog.setIsLike(false);
                if (!(starService.findById((Integer) session.getAttribute("userId"),
                        blog.getBlogId())).isEmpty()) {
                    blog.setIsStar(true);
                } else
                    blog.setIsStar(false);
            }
            model.addAttribute("blogs", blogs);
            model.addAttribute("avatars", blogService.getBlogAvatars(blogs));
            return "/";
        }
        else {
            model.addAttribute("loginMsg", "Wrong email address or password!");
            return "login";
        }
    }
}
