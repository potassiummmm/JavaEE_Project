package com.example.login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //    @RequestMapping
//    @GetMapping
//    @DeleteMapping
//    @RequestMapping
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功，session中加入登录用户名，用于在成功的首页中展示
            session.setAttribute("loginUser",username);
            //此处用重定向，会被我们定义的视图解析器解析，寻找对应dashboard.html
            return "redirect:/main.html";
        }else{
            //登录失败,设置失败信息并返回登录页面
            map.put("msg","用户名密码错误");
            //由于此处不是重定向，所以相当于根据字符串直接去templates下找login.html
            //所以不能写成返回"/"或者"/index.html",否则会报找不到页面
            return "login";
        }
    }

}
