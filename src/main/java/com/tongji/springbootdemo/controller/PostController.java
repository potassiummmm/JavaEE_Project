package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.BlogMapper;
import com.tongji.springbootdemo.mapper.CommentMapper;
import com.tongji.springbootdemo.mapper.UserMapper;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.User;
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
    private BlogMapper blogMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping
    public String post(Model model) {
        if (blogMapper.findAll().isEmpty())
            return "404";
        model.addAttribute("blog", blogMapper.findAll().toArray()[0]);
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
        commentMapper.addComment(blogId, comment, userMapper.findByEmail(authorEmail).get(0).getUserId(), date);
        return "redirect:/post/{blogId}";
    }

    @RequestMapping("/sendBlog/{authorEmail}")
    public String sendBlog(@RequestParam("blogTitle") String title, @RequestParam("blogContent") String content, @PathVariable("authorEmail") String authorEmail){
        //TODO: Add database service, use date.toString() to get date string(see main method in Blog.java)
        User author = userMapper.findByEmail(authorEmail).get(0);
        Date date = new Date(System.currentTimeMillis());
        blogMapper.addBlog(author.getUserId(),blogMapper.findByAuthor(author.getUserId()).size()+1,title,content, author.getNickname(), 0,0,date);
        return "redirect:/post/1";
    }
}
