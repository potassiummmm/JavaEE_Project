package com.tongji.springbootdemo.controller;

import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.model.Like;
import com.tongji.springbootdemo.model.Star;
import com.tongji.springbootdemo.model.User;
import com.tongji.springbootdemo.service.BlogService;
import com.tongji.springbootdemo.service.LikeService;
import com.tongji.springbootdemo.service.StarService;
import com.tongji.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StarController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private StarService starService;
	
	@RequestMapping( "/star/{blogId}")
	public String addStar(@PathVariable("blogId") Integer blogId, Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		Blog blog = blogService.findById(blogId);
		List<Star> stars = starService.findById(userId, blogId);
		if(!stars.isEmpty()) {
			blogService.updateStar(blog.getStar() - 1, blogId);
			starService.deleteStar(userId, blogId);
		}
		else {
			blogService.updateStar(blog.getStar() + 1, blogId);
			starService.addStar(userId, blogId);
		}
		List<Blog> blogss = blogService.findAll();
		//Collection<Blog> blogs = blogDao.getBlogs();
		model.addAttribute("blogs", blogss);
		return "index";
	}
	
	@RequestMapping( "/starList/{authorId}")
	public String starList(@PathVariable("authorId") Integer authorId,Model model, HttpSession session) {
		List<Star> stars = starService.findByUserId(authorId);
		List<Blog> myStarBlog=new ArrayList<>();
		for (Star star:stars
		) {
			myStarBlog.add(blogService.findById(star.getBlogId()));
		}
		User user=userService.findById(authorId);
		model.addAttribute("user",user);
		model.addAttribute("blogs", myStarBlog);
		return "starList";
	}
	
	@RequestMapping( "/star/deleteBlog/{blogId}")
	public String deleteStarBlog(@PathVariable("blogId") Integer blogId, Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		Blog blog=blogService.findById(blogId);
		starService.deleteStar(userId,blogId);
		blogService.updateStar(blog.getStar() - 1, blogId);
		List<Star> stars=starService.findByUserId(userId);
		List<Blog> myStarBlog=new ArrayList<>();
		for (Star star:stars
		) {
			myStarBlog.add(blogService.findById(star.getBlogId()));
		}
		User user=userService.findById(userId);
		model.addAttribute("user",user);
		model.addAttribute("blogs", myStarBlog);
		return "starList";
	}
}
