package com.tongji.springbootdemo.mapper;

import com.tongji.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("INSERT INTO users(nickname,email,password,registrationTime) VALUES(#{nickname},#{email},#{password},#{registrationTime})")
    int addUser(String nickname, String email, String password, Date registrationTime);

    @Select("SELECT * FROM users where userId=#{userId}")
    List<User> findById(Integer userId);

    @Select("SELECT * FROM users where email=#{email}")
    List<User> findByEmail(String email);

    @Delete("DELETE FORM users where email=#{email}")
    int deleteUser(String email);
}
