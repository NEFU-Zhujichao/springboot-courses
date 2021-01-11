package com.example.springbootspringmvcexamples.example04.passwordencoder.controller;

import com.example.springbootspringmvcexamples.example04.passwordencoder.entity.User;
import com.example.springbootspringmvcexamples.example04.passwordencoder.service.UserService04;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/example04/")
@Slf4j
public class ExController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService04 userService04;
    @PostMapping("login")
    public Map login(@RequestBody User user) {
        User u = userService04.getUser(user.getUserName());
        if (u == null || !passwordEncoder.matches(user.getPassword(),u.getPassword())){
            log.debug("登陆失败");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名或密码错误");
        }else {
            log.debug("登陆成功");
        }
        return Map.of("user",u);
    }
}
