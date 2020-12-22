package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.service.BlogService;
import com.tongji.springbootdemo.service.LikeService;
import com.tongji.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LikeController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@RequestMapping( "/like/{blogId}")
	public String addLike(@PathVariable("blogId") Integer blogId, Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		Blog blog = blogService.findById(blogId);
		List<Like> likes = likeService.findById(userId, blogId);
		if(!likes.isEmpty()) {
			blogService.updateLike(blog.getLike() - 1, blogId);
			likeService.deleteLike(userId, blogId);
		}
		else {
			blogService.updateLike(blog.getLike() + 1, blogId);
			String nickname = userService.findById(userId).getNickname();
			likeService.addLike(userId, nickname, blogId);
		}
		List<Blog> blogss = blogService.findAll();
		//Collection<Blog> blogs = blogDao.getBlogs();
		model.addAttribute("blogs", blogss);
		return "index";
	}
	
	@RequestMapping( "/likeList/{blogId}")
	public String likeList(@PathVariable("blogId") Integer blogId, Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		Blog blog = blogService.findById(blogId);
		List<Like> likes = likeService.findById(userId, blogId);
		model.addAttribute("likes", likes);
		return "likeList";
	}
}
