package com.example.springbootspringexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrototypeBean {
    @Autowired
    private SingletonBean singletonBean;
    public void getSingle(){
        log.debug("singleton in Prototype: {}",singletonBean);
    }
}
