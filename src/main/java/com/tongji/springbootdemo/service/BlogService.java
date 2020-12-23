package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.Blog;

import java.sql.Timestamp;
import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    List<Blog> findByMostRecent();

    List<Blog> findByMostFavored();

    List<Blog> findByAuthor(Integer authorId);

    Blog findById(Integer blogId);

    String getAuthorName(Integer blogId);
    
    void updateLike(Integer like,Integer blogId);
    
    int addBlog(Integer privateIndex, Integer authorId, String title, String content, Integer like, Integer view,Integer star, Timestamp date);
    
    void updateView(Integer view,Integer blogId);
    
    int deleteBlog(Integer blogId);
    
    void updateStar(Integer star,Integer blogId);
}
