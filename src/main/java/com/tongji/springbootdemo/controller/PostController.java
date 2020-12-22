package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.Comment;
import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.model.User;
import com.tongji.springbootdemo.service.LikeService;
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

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private LikeService likeService;

    @RequestMapping
    public String post(Model model) {
        if (blogService.findAll().isEmpty())
            return "404";
        model.addAttribute("blog", blogService.findAll().toArray()[0]);
        return "post";
    }

    @RequestMapping("/{blogId}")
    public String view(@PathVariable("blogId") Integer blogId, Model model){
        Blog blog=blogService.findById(blogId);
        blogService.updateView(blog.getView()+1,blogId);
        model.addAttribute("blog", blog);
        List<Comment> comments = commentService.findByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "post";
    }

    @RequestMapping("/sendComment/{authorId}/{blogId}")
    public String addComment(@RequestParam("commentContent") String comment, @PathVariable("authorId") Integer authorId, @PathVariable("blogId") Integer blogId){
        //TODO: Add database service here
        Timestamp date = new Timestamp(System.currentTimeMillis());
        commentService.addComment(blogId, comment, authorId, date);
        return "redirect:/post/{blogId}";
    }

    @RequestMapping("/sendBlog/{authorId}")
    public String sendBlog(@RequestParam("blogTitle") String title, @RequestParam("blogContent") String content, @PathVariable("authorId") Integer authorId, Model model){
        //TODO: Add database service, use date.toString() to get date string(see main method in Blog.java)
        Timestamp date = new Timestamp(System.currentTimeMillis());
        Integer privateId=blogService.findByAuthor(authorId).size()+1;
        model.addAttribute("blogId", blogService.findAll().size());
        blogService.addBlog(privateId,authorId,title,content, 0,0,date);
        List<Blog> blogs = blogService.findAll();
        Blog blog = blogs.get(blogs.size()-1);
        String url = "redirect:/post/" + blog.getBlogId();
        return url;
    }
    
    @RequestMapping("/deleteBlog/{blogId}")
    public String sendBlog(@PathVariable("blogId") Integer blogId, Model model, HttpSession session){
    
        likeService.deleteLikeByBlogId(blogId);
        blogService.deleteBlog(blogId);
        
        Integer userId=(Integer) session.getAttribute("userId");
        User user=userService.findById(userId);
        model.addAttribute("user",user);
        model.addAttribute("blogs", blogService.findByAuthor(userId));
        return "about";
    }
    
}
