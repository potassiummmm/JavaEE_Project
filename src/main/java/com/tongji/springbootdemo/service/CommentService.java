package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.Comment;

import java.sql.Date;
import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findByBlogId(Integer blogId);

    int addComment(Integer blogId, String content, Integer senderId, Date date);
}
