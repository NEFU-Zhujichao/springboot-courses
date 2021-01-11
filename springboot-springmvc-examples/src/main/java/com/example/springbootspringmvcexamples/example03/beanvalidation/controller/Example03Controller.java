package com.example.springbootspringmvcexamples.example03.beanvalidation.controller;


import com.example.springbootspringmvcexamples.example03.beanvalidation.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/example03/")
@Validated
public class Example03Controller {

    @PostMapping("users")
    public Map postUser(@Valid @RequestBody User user){
        return Map.of();
    }

    @GetMapping("users/{uid}/file")
    public void getTypeMismatchException(@PathVariable int uid){
    }

    @GetMapping("users/{owner}")
    public void getViolationException(
            @Size(min = 2,max = 6,message = "用户信息错误")
            @PathVariable String owner){

    }
}
