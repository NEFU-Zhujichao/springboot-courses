package com.example.springbootspringexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {
    @Pointcut("execution(* com.example.springbootspringexamples.example02.aop..*.*(..))")
    public void pointcut() {}
    @Before("pointcut()")
    public void before(){
        log.debug("before()");
    }
    @After("pointcut()")
    public void after(){
        log.debug("after()");
    }
}
