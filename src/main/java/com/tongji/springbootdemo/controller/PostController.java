package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.BlogMapper;
import com.tongji.springbootdemo.mapper.CommentMapper;
import com.tongji.springbootdemo.mapper.UserMapper;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.User;
import com.tongji.springbootdemo.service.impl.BlogServiceImpl;
import com.tongji.springbootdemo.service.impl.CommentServiceImpl;
import com.tongji.springbootdemo.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Collection;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping
    public String post(Model model) {
        if (blogService.findAll().isEmpty())
            return "404";
        model.addAttribute("blog", blogService.findAll().toArray()[0]);
        return "post";
    }

    @RequestMapping("/{blogId}")
    public String post(Model model, @PathVariable("blogId") Integer blogId ){
        //TODO
//        Blog b = blogMapper.getBlogById(id);
//        if (b == null)
//            return "404";
//        model.addAttribute("blog", b);
////        return new ModelAndView("index", "blogs", blogs);
        return "post";
    }

    @RequestMapping("/sendComment/{blogId}/{authorEmail}")
    public String addComment(@RequestParam("commentContent") String comment, @PathVariable("blogId") Integer blogId, @PathVariable("authorEmail") String authorEmail){
        //TODO: Add database service here
        Date date = new Date(System.currentTimeMillis());
        commentService.addComment(blogId, comment, userService.findByEmail(authorEmail).get(0).getUserId(), date);
        return "redirect:/post/{blogId}";
    }

    @RequestMapping("/sendBlog/{authorEmail}")
    public String sendBlog(@RequestParam("blogTitle") String title, @RequestParam("blogContent") String content, @PathVariable("authorEmail") String authorEmail){
        //TODO: Add database service, use date.toString() to get date string(see main method in Blog.java)
        User author = userService.findByEmail(authorEmail).get(0);
        Date date = new Date(System.currentTimeMillis());
        blogService.addBlog(author.getUserId(),blogService.findByAuthor(author.getUserId()).size()+1,title,content, 0,0,date);
        return "redirect:/post/1";
    }
}
