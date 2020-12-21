package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.mapper.BlogMapper;
import com.tongji.springbootdemo.mapper.UserMapper;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Blog> findAll() {
        return blogMapper.findAll();
    }

    @Override
    public List<Blog> findByAuthor(Integer authorId) {
        return blogMapper.findByAuthor(authorId);
    }

    @Override
    public Blog findById(Integer blogId) {
        if(blogMapper.findById(blogId).isEmpty()){
            return null;
        }
        return blogMapper.findById(blogId).get(0);
    }

    @Override
    public String getAuthorName(Integer blogId) {
        Integer authorId = blogMapper.findById(blogId).get(0).getAuthorId();
        return userMapper.findById(authorId).get(0).getNickname();
    }

    @Override
    public int addBlog(Integer privateIndex, Integer authorId, String title, String content, Integer like, Integer view, Date date) {
        return blogMapper.addBlog(privateIndex, authorId, title, content, like, view, date);
    }
}
