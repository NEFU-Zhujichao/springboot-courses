package com.example.springbootspringexamples.example03;

import com.example.springbootspringexamples.example03.jointpoint.AOPService03;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPServiceTest {
    @Autowired
    private AOPService03 aopService03;
    @Autowired
    private AopService03 aopService04;
    @Test
    public void test_hello() {
        aopService03.hello("chao");
    }

    @Test
    public void test_get(){
        aopService04.get();
    }
}
