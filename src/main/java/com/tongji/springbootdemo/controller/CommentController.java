package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.mapper.CommentMapper;
import com.tongji.springbootdemo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping("/commentList")
    public String getCommentList(Model model) {
        List<Comment> comments=commentMapper.findAll();
        model.addAttribute("comments",comments);
        return "commentList";
    }
}