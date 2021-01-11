package com.example.springbootspringexamples.example03.jointpoint;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect03 {
    @Pointcut("execution(* com.example.springbootspringexamples.example03..*.*(..))")
    public void pointcut() {
    }
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.debug("before()");
        log.debug(joinPoint.getTarget().getClass().getName());
        for (Object a : joinPoint.getArgs()) {
            log.debug("{}",a);
        }
        log.debug(joinPoint.getSignature().getName());
        log.debug(joinPoint.getThis().getClass().getName());
    }
    @After("pointcut()")
    public void after(){
        log.debug("after()");
    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("around()");
        Object[] objects = joinPoint.getArgs();
        objects[0] = "qi";
        return joinPoint.proceed(objects);
    }
}
