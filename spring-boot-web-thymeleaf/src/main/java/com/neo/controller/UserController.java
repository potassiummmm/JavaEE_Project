package com.neo.controller;

import javax.validation.Valid;

import com.neo.model.Message;
import com.neo.model.User;
import com.neo.repository.MessageRepository;
import com.neo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public UserController(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @GetMapping("login")
    public ModelAndView login(@ModelAttribute User user) {
        Iterable<User> users = this.userRepository.findAll();
        return new ModelAndView("redirect:/user/login.html");
    }

    @PostMapping("verify")
    public ModelAndView verifyUser(@Valid @ModelAttribute(value="user") User user, BindingResult result, RedirectAttributes redirect) {
//        if (result.hasErrors()) {
//            return new ModelAndView("user/login", "loginErrors", result.getAllErrors());
//        }
//        User foundUser = this.userRepository.findUser(userName);
//        if(foundUser == null || !foundUser.getPassword().equals(password)) {
//            return "user/login";
//        }
//        Iterable<Message> messages = this.messageRepository.findAll();
//        return new ModelAndView("messages/list", "messages", messages);
        return new ModelAndView("redirect:/messages/list.html");
    }
}