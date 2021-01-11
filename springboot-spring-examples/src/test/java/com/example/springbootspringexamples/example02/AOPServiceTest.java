package com.example.springbootspringexamples.example02;

import com.example.springbootspringexamples.example02.aop.AOPService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPServiceTest {
    @Autowired
    private AOPService aopService;
    @Autowired
    private AopService02 aopService02;
    @Test
    public void test_get(){
        aopService.get();
    }

    @Test
    public void test_get2(){
        aopService02.get();
    }
}
