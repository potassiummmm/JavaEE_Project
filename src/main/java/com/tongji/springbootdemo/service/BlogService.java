package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.Blog;

import java.sql.Timestamp;
import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    List<Blog> findByAuthor(Integer authorId);

    Blog findById(Integer blogId);

    String getAuthorName(Integer blogId);

    int addBlog(Integer privateIndex, Integer authorId, String title, String content, Integer like, Integer view, Timestamp date);
}
