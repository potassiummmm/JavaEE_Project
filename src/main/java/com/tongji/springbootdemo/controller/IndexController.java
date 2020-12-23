package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.User;
import com.tongji.springbootdemo.service.UserService;
import com.tongji.springbootdemo.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        List<Blog> blogs = blogService.findByMostRecent();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @RequestMapping("/sorted")
    public String sortedIndex(@RequestParam("method") String method, Model model){
        List<Blog> blogs = null;
        if(method.equals("Order By Date")){
            blogs = blogService.findByMostRecent();
        }
        else{
            blogs = blogService.findByMostFavored();
        }
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @RequestMapping("/index")
    public String index2(Model model) {
        return "redirect:/";
    }

    @RequestMapping("/about/{userId}")
    public String about(@PathVariable("userId") Integer userId, Model model, HttpSession session) {
        User user=userService.findById(userId);
        model.addAttribute("user",user);
        model.addAttribute("blogs", blogService.findByAuthor(userId));
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(Model model, HttpSession session) { return "contact"; }

    @RequestMapping("/logOut")
    public String logOut(Model model, HttpSession session){
        session.removeAttribute("currentUser");
        return "redirect:/";
    }

}
