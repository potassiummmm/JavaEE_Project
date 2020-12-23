package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Mapper
public interface BlogMapper {
    @Select("SELECT * FROM blogs order by date")
    List<Blog> findAll();

    @Select("SELECT * FROM blogs order by date DESC")
    List<Blog> findByMostRecent();

    @Select("SELECT * FROM blogs order by `like` DESC")
    List<Blog> findByMostFavored();

    @Select("SELECT * FROM blogs where blogId=#{blogId} order by date")
    List<Blog> findById(Integer blogId);

    @Select("SELECT * FROM blogs where authorId=#{authorId} order by date")
    List<Blog> findByAuthor(Integer authorId);

    @Insert("INSERT INTO blogs(privateIndex,authorId,authorNickname,title,content,`like`,`view`,date) VALUES(#{privateIndex},#{authorId},#{authorNickname},#{title},#{content},#{like},#{view},#{date})")
    int addBlog(Integer privateIndex, Integer authorId, String authorNickname, String title, String content, Integer like, Integer view, Timestamp date);
    
    @Update("UPDATE blogs SET `like`=#{like} where blogId=#{blogId}")
    void updateLike(Integer like,Integer blogId);
    
    @Update("UPDATE blogs SET `view`=#{view} where blogId=#{blogId}")
    void updateView(Integer view,Integer blogId);
    
    @Delete("DELETE FROM blogs WHERE blogId=#{blogId}")
    int deleteBlog(Integer blogId);
    
    @Update("UPDATE blogs SET `star`=#{star} where blogId=#{blogId}")
    void updateStar(Integer star,Integer blogId);
}