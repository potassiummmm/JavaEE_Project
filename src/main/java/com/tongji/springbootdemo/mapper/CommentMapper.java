package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Timestamp;

@Repository
@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comments")
    List<Comment> findAll();

    @Select("SELECT * FROM comments where blogId=#{blogId} order by date")
    List<Comment> findByBlogId(Integer blogId);

    @Insert("INSERT INTO comments(blogId,content,senderId,date) VALUES(#{blogId},#{content},#{senderId},#{date})")
    int addComment(Integer blogId, String content, Integer senderId, Timestamp date);
}