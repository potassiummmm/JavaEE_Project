package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.dao.BlogDao;
import com.tongji.springbootdemo.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private BlogDao blogDao=new BlogDao();

    @RequestMapping("/index")
    public ModelAndView index(Model model){
        Iterable<Blog> blogs = blogDao.getBlogs();
        return new ModelAndView("index", "blogs", blogs);
    }

    @RequestMapping("/about")
    public String about(Model model, HttpSession session) {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(Model model, HttpSession session) { return "contact"; }

}
