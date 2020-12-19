package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.dao.BlogDao;
import com.tongji.springbootdemo.model.Blog;
import org.apache.catalina.connector.Response;
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
import java.util.Collection;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) throws IOException {
        if(!StringUtils.isEmpty(email) && !StringUtils.isEmpty(password)){
            session.setAttribute("loginUser", email);
            BlogDao blogDao = new BlogDao();
            Collection<Blog> blogs = blogDao.getBlogs();
            model.addAttribute("blogs", blogs);
            return "index";
        }
        model.addAttribute("loginMsg","Wrong email address or password!");
        return "login";
    }
}
