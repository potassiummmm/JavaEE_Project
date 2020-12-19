package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();
    @Insert("INSERT INTO users(nickname,email,password) VALUES(#{nickname},#{email},#{password})")
    int addUser(String nickname,String email,String password);
}
