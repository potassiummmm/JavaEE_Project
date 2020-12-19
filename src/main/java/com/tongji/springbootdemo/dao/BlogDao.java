package com.tongji.springbootdemo.dao;

import com.tongji.springbootdemo.model.Blog;
import com.tongji.springbootdemo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogDao {
    private static Map<Integer, Blog> blogs=null;

    static{
        blogs=new HashMap<Integer, Blog>();
        blogs.put(101,new Blog(1,"haha","hahahaha","a", Calendar.getInstance(),0,0));
        blogs.put(102,new Blog(2,"hehe","hehehehe","b", Calendar.getInstance(),0,0));
        blogs.put(103,new Blog(3,"pa","kuaipa","c", Calendar.getInstance(),0,0));
    }

    public Collection<Blog> getBlogs(){
        return new ArrayList<Blog>(blogs.values());
    }

    public Blog getBlogById(Integer id){
        return blogs.get(id);
    }
}
