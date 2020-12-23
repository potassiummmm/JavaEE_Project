package com.tongji.springbootdemo.service.impl;

import com.tongji.springbootdemo.mapper.StarMapper;
import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tongji.springbootdemo.model.Star;

import java.util.List;

@Service
public class StarServiceImpl implements StarService {
	@Autowired
	private StarMapper starMapper;
	
	@Override
	public int deleteStarByBlogId(Integer blogId) {
		return starMapper.deleteStarByBlogId(blogId);
	}
	
	@Override
	public List<Star> findByUserId(Integer blogId) {
		return starMapper.findByUserId(blogId);
	}
	
	@Override
	public int deleteStar(Integer userId, Integer blogId) {
		return starMapper.deleteStar(userId,blogId);
	}
	
	@Override
	public List<Star> findById(Integer userId, Integer blogId) {
		return starMapper.findById(userId,blogId);
	}
	
	@Override
	public int addStar(Integer userId, Integer blogId) {
		return starMapper.addStar(userId,blogId);
	}
}
