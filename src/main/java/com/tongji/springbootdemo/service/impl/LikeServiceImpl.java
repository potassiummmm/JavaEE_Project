package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.mapper.LikeMapper;
import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
	@Autowired
	private LikeMapper likeMapper;
	@Override
	public int addLike(Integer userId, String nickname, Integer blogId) {
		return likeMapper.addLike(userId,nickname,blogId);
	}
	
	@Override
	public List<Like> findById(Integer userId, Integer blogId) {
		return likeMapper.findById(userId,blogId);
	}
	
	@Override
	public int deleteLike(Integer userId, Integer blogId) {
		return likeMapper.deleteLike(userId,blogId);
	}
	
	@Override
	public List<Like> findByBlogId(Integer blogId) {
		return likeMapper.findByBlogId(blogId);
	}
	
	@Override
	public int deleteLikeByBlogId(Integer blogId) {
		return likeMapper.deleteLikeByBlogId(blogId);
	}
}
