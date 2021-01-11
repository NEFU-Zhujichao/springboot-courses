package com.example.springbootspringmvcexamples.example06.interceptor.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/example06/")
@Slf4j
public class ExampleController06 {

    @GetMapping("admin")
    public Map getLogin(){
        log.debug("进入Controller了");
        return Map.of();
    }
}
