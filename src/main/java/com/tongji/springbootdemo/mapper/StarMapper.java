package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.model.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StarMapper {
	@Insert("INSERT INTO stars(userId,blogId) VALUES(#{userId},#{blogId})")
	int addStar(Integer userId,Integer blogId);
	
	@Select("SELECT * FROM stars WHERE userId=#{userId} AND blogId=#{blogId}")
	List<Star> findById(Integer userId, Integer blogId);
	
	@Select("SELECT * FROM stars WHERE userId=#{userId}")
	List<Star> findByUserId(Integer userId);
	
	@Delete("DELETE FROM stars WHERE userId=#{userId} AND blogId=#{blogId}")
	int deleteStar(Integer userId,Integer blogId);
	
	@Delete("DELETE FROM stars WHERE blogId=#{blogId}")
	int deleteStarByBlogId(Integer blogId);
}
