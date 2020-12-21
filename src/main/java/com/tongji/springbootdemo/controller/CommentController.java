package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Comment;
import com.tongji.springbootdemo.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @RequestMapping("/commentList")
    public String getCommentList(Model model) {
        List<Comment> comments=commentService.findAll();
        model.addAttribute("comments",comments);
        return "commentList";
    }
}