package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")//显示所有用户
    List<User> findAll();
    @Insert("INSERT INTO users(nickname,email,password) VALUES(#{nickname},#{email},#{password})")//注册 添加用户
    int addUser(String nickname,String email,String password);
    @Select("SELECT * FROM users where email=#{email}")//通过邮箱查找用户
    List<User> findByEmail(String email);
    @Delete("DELETE FORM users where email=#{email}")//注销账户
    int deleteUser(String email);
}
