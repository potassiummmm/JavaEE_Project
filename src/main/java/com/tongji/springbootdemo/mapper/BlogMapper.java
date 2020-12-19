package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {
    @Select("SELECT * FROM blogs")
    List<Blog> findAll();
    @Insert("INSERT INTO blogs(blogId,title,content,author,like,view) VALUES(#{blogId},#{title},#{content},#{author},#{like},#{view})")
    int addBlog(Integer blogId,String title,String content,String author,Integer like,Integer view);
}