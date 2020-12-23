package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.model.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StarService {
	int addStar(Integer userId,Integer blogId);
	
	List<Star> findById(Integer userId, Integer blogId);
	
	List<Star> findByUserId(Integer blogId);
	
	int deleteStar(Integer userId,Integer blogId);
	
	int deleteStarByBlogId(Integer blogId);
}
