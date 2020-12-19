package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAll();
    @Insert("INSERT INTO user VALUES(#{name},)")
    int addUser(User user);
}
