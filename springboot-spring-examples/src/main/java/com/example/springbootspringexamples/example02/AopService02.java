package com.example.springbootspringexamples.example02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AopService02 {
    public void get(){
        log.debug("我是AopService02，不被切点所切");
    }
}
