package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.mapper.*;
import com.tongji.springbootdemo.model.Comment;
import com.tongji.springbootdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public List<Comment> findByBlogId(Integer blogId) {
        return commentMapper.findByBlogId(blogId);
    }

    @Override
    public int addComment(Integer blogId, String content, Integer senderId, Timestamp date) {
        return commentMapper.addComment(blogId, content, senderId, userMapper.findById(senderId).get(0).getNickname(), date);
    }
}
