package com.tongji.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Star {
	private int userId;
	private int blogId;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getBlogId() {
		return blogId;
	}
	
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
}
