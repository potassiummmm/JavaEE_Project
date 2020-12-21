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
import java.util.List;

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

    @RequestMapping("/{authorId}/{blogId}")
    public String view(@PathVariable("authorId") Integer authorId, @PathVariable("blogId") Integer blogId, Model model){
        List<Blog> blogs = blogMapper.findByAuthor(authorId);
        model.addAttribute("blog", blogs.get(blogId-1));
        return "post";
    }

    @RequestMapping("/sendComment/{authorId}/{blogId}")
    public String addComment(@RequestParam("commentContent") String comment, @PathVariable("authorId") Integer authorId, @PathVariable("blogId") Integer blogId){
        //TODO: Add database service here
        Date date = new Date(System.currentTimeMillis());
        commentMapper.addComment(blogId, comment, userMapper.findById(authorId).get(0).getUserId(), date);
        return "redirect:/post/sendComment/{authorId}/{blogId}";
    }

    @RequestMapping("/sendBlog/{authorId}")
    public String sendBlog(@RequestParam("blogTitle") String title, @RequestParam("blogContent") String content, @PathVariable("authorId") Integer authorId){
        //TODO: Add database service, use date.toString() to get date string(see main method in Blog.java)
        User author = userMapper.findById(authorId).get(0);
        Date date = new Date(System.currentTimeMillis());
        Integer privateId=blogMapper.findByAuthor(authorId).size()+1;
        blogMapper.addBlog(authorId,privateId,title,content, author.getNickname(), 0,0,date);
        return "redirect:/post/{authorId}/{privateId}";
    }
}
