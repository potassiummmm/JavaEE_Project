package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {

    @GetMapping("{id}")
    public String getBlog(@PathVariable("id") Blog blog, Model model) {
        model.addAttribute("blog", blog);
        return "post";
    }
}
