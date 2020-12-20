package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.dao.BlogDao;
import com.tongji.springbootdemo.mapper.BlogMapper;
import com.tongji.springbootdemo.model.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogDao blogDao=new BlogDao();

    @RequestMapping
    public String post(Model model) {
        if (blogDao.getBlogs().isEmpty())
            return "404";
        model.addAttribute("blog", blogDao.getBlogs().toArray()[0]);
        return "post";
    }

    @RequestMapping("/{id}")
    public String post(Model model, @PathVariable("id") Integer id ){
        Blog b = blogDao.getBlogById(id);
        if (b == null)
            return "404";
        model.addAttribute("blog", b);
//        return new ModelAndView("index", "blogs", blogs);
        return "post";
    }

    @RequestMapping("/comment")
    public String addComment(@RequestParam("commentContent") String comment){
        //TODO: Add database service here
        return "post";
    }

    @RequestMapping("/sendBlog/{author}")
    public String sendBlog(@RequestParam("blogTitle") String title, @RequestParam("blogContent") String content, @PathVariable("author") String author){
        //TODO: Add database service, use date.toString() to get date string(see main method in Blog.java)

        return "post";
    }
}
