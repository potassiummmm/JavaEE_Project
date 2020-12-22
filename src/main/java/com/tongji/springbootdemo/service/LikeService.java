package com.tongji.springbootdemo.service;

import com.tongji.springbootdemo.model.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LikeService {
	int addLike(Integer userId,String nickname,Integer blogId);
	
	List<Like> findById(Integer userId, Integer blogId);
	
	int deleteLike(Integer userId,Integer blogId);
}
