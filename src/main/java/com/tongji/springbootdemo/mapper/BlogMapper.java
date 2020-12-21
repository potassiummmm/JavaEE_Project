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

    @Select("SELECT * FROM blogs where authorId=#{authorId} order by date")
    List<Blog> findByAuthor(Integer authorId);

    @Insert("INSERT INTO blogs(authorId,privateIndex,title,content,like,view,date) VALUES(#{authorId},#{privateIndex},#{title},#{content},#{like},#{view},#{date})")
    int addBlog(Integer authorId, Integer privateIndex, String title, String content, String author, Integer like, Integer view, Date date);
}