package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.mapper.BlogMapper;
import com.tongji.springbootdemo.mapper.UserMapper;
import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    public List<Blog> findByMostRecent(){
        return blogMapper.findByMostRecent();
    }

    @Override
    public List<Blog> findByMostFavored() {
        return blogMapper.findByMostFavored();
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
    public String getBlogAuthorAvatar(Integer blogId) {
        Integer authorId = blogMapper.findById(blogId).get(0).getAuthorId();
        return userMapper.findById(authorId).get(0).getUserImage();
    }

    @Override
    public List<String> getBlogAvatars(List<Blog> blogs) {
        List<String> avatars = new ArrayList<>();
        for (Blog blog : blogs) {
            avatars.add(getBlogAuthorAvatar(blog.getBlogId()));
        }
        return avatars;
    }

    @Override
    public int addBlog(Integer privateIndex, Integer authorId,String title, String content, Integer like, Integer view,Integer star, Timestamp date) {
        return blogMapper.addBlog(privateIndex, authorId, userMapper.findById(authorId).get(0).getNickname(), title, content, like, view,star, date);
    }
    
    @Override
    public void updateLike(Integer like, Integer blogId) {
        blogMapper.updateLike(like,blogId);
    }
    
    @Override
    public void updateView(Integer view, Integer blogId) {
        blogMapper.updateView(view,blogId);
    }
    
    @Override
    public int deleteBlog(Integer blogId) {
        return blogMapper.deleteBlog(blogId);
    }
    
    @Override
    public void updateStar(Integer star, Integer blogId) {
        blogMapper.updateStar(star, blogId);
    }
}
