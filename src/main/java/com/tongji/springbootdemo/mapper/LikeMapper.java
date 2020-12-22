package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Mapper
public interface LikeMapper
{
	@Insert("INSERT INTO likes(userId,nickname,blogId) VALUES(#{userId},#{nickname},#{blogId})")
	int addLike(Integer userId,String nickname,Integer blogId);
	
	@Select("SELECT * FROM likes WHERE userId=#{userId} AND blogId=#{blogId}")
	List<Like> findById(Integer userId,Integer blogId);
	
	@Delete("DELETE FROM likes WHERE userId=#{userId} AND blogId=#{blogId}")
	int deleteLike(Integer userId,Integer blogId);
}
