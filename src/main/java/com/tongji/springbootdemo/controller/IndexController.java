package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.User;
import com.tongji.springbootdemo.service.LikeService;
import com.tongji.springbootdemo.service.StarService;
import com.tongji.springbootdemo.service.UserService;
import com.tongji.springbootdemo.service.impl.BlogServiceImpl;
import com.tongji.springbootdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private LikeService likeService;
    
    @Autowired
    private StarService starService;

    @RequestMapping("/")
    public String index(Model model,HttpSession session){
        if(session.getAttribute("userId")==null)
        {
            List<Blog> blogs = blogService.findByMostRecent();
            model.addAttribute("blogs", blogs);
            return "index";
        }
        Integer userId=(Integer)session.getAttribute("userId");
        List<Blog> blogs = blogService.findByMostRecent();
        for (Blog blog : blogs) {
            if (!(likeService.findById(userId, blog.getBlogId())).isEmpty()) {
                blog.setIsLike(true);
            } else {
                blog.setIsLike(false);
            }
            if (!(starService.findById(userId, blog.getBlogId())).isEmpty()) {
                blog.setIsStar(true);
            } else {
                blog.setIsStar(false);
            }
        }
        User usr = userService.findById(userId);
        model.addAttribute("me", usr);
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @RequestMapping("/sorted")
    public String sortedIndex(@RequestParam("method") String method, Model model,HttpSession session){
        List<Blog> blogs = null;
        if(method.equals("Order By Date")){
            blogs = blogService.findByMostRecent();
        }
        else{
            blogs = blogService.findByMostFavored();
        }
        Integer userId=(Integer) session.getAttribute("userId");
        for (Blog blog : blogs) {
            if (!(likeService.findById(userId, blog.getBlogId())).isEmpty()) {
                blog.setIsLike(true);
            } else
                blog.setIsLike(false);
            if (!(starService.findById(userId, blog.getBlogId())).isEmpty()) {
                blog.setIsStar(true);
            } else
                blog.setIsStar(false);
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("method", method);
        User usr = userService.findById(userId);
        model.addAttribute("me", usr);
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

    @RequestMapping("/about/{userId}/addAvatar")
    public String avatar(@PathVariable("userId") Integer userId, Model model, HttpSession session) {
        User user=userService.findById(userId);
        model.addAttribute("user",user);
        return "postAvatar";
    }

    @RequestMapping(value="/about/{userId}/addAvatar/submit", headers=("content-type=multipart/*"))
    public String upload(@PathVariable("userId") Integer userId, @RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "failed";
        }
        userService.updateImage(userId, file);
        return "redirect:/";
    }

    @RequestMapping("/logOut")
    public String logOut(Model model, HttpSession session){
        session.removeAttribute("currentUser");
        return "redirect:/";
    }

}
