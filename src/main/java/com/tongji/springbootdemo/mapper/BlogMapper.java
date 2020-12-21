package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Mapper
public interface BlogMapper {
    @Select("SELECT * FROM blogs")
    List<Blog> findAll();

    @Select("SELECT * FROM blogs where blogId=#{blogId} order by date")
    List<Blog> findById(Integer blogId);

    @Select("SELECT * FROM blogs where authorId=#{authorId} order by date")
    List<Blog> findByAuthor(Integer authorId);

    @Insert("INSERT INTO blogs(privateIndex,authorId,title,content,`like`,`view`,date) VALUES(#{privateIndex},#{authorId},#{title},#{content},#{like},#{view},#{date})")
    int addBlog(Integer privateIndex, Integer authorId, String title, String content, Integer like, Integer view, Date date);
}