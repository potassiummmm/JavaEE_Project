package com.tongji.springbootdemo.dao;

import com.tongji.springbootdemo.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogDao {
    private static Map<Integer, Blog> blogs=null;

    static{
        blogs=new HashMap<Integer, Blog>();
        blogs.put(101,new Blog(101,"haha","hahahaha","a", Calendar.getInstance(),0,0));
        blogs.put(102,new Blog(102,"hehe","hehehehe","b", Calendar.getInstance(),0,0));
        blogs.put(103,new Blog(103,"pa","kuaipa","c", Calendar.getInstance(),0,0));
    }

    public Collection<Blog> getBlogs(){
        return new ArrayList<Blog>(blogs.values());
    }

    public Blog getBlogById(Integer id){
        return blogs.get(id);
    }
}
