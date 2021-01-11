package com.example.springbootspringmvcexamples.example02.handlingexception.controller;

import com.example.springbootspringmvcexamples.example02.handlingexception.entity.User;
import com.example.springbootspringmvcexamples.example02.handlingexception.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/example02/")
public class ExampleController02 {
    @Autowired
    private UserService02 userService02;
    @GetMapping("exception")
    public void getException() {
        userService02.addFile();
    }
    @GetMapping("exception2")
    public void getException2() {
        userService02.addFile2();
    }
    @PostMapping("login")
    public void login(@RequestBody User user){
        if (!("chao".equals(user.getUserName()) && "123456".equals(user.getPassword()))){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名或密码错误");
        }
    }
}
