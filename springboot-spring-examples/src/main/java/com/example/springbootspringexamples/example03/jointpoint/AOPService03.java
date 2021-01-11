package com.example.springbootspringexamples.example03.jointpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AOPService03 {
    public void hello(String name) {
        log.debug("welcome " + name);
    }
}
