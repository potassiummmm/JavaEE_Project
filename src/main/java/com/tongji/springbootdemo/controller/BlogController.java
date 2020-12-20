package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.BlogMapper;
import com.tongji.springbootdemo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @RequestMapping("/blogList")
    public String getUserList(Model model) {
        List<Blog> blogs=blogMapper.findAll();
        model.addAttribute("blogs",blogs);
        return "blogList";
    }
}
