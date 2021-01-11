package com.example.springbootspringexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SingletonBean {
    @Autowired
    private PrototypeBean prototypeBean;
    public void getProto(){
        log.debug("prototype in Singleton: {}",prototypeBean);
    }
}
