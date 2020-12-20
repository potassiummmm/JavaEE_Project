package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comments")
    List<Comment> findAll();
    @Insert("INSERT INTO comments(blogId,content,senderId,date) VALUES(#{blogId},#{content},#{senderId},#{view})")
    int addComment(Integer blogId, String content, Integer senderId, Date date);
}