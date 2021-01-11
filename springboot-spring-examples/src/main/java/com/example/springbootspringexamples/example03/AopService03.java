package com.example.springbootspringexamples.example03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AopService03 {
    public void get(){
        log.debug("我会被切点所切");
    }
}
