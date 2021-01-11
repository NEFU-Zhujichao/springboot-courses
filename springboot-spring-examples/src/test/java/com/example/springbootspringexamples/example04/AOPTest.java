package com.example.springbootspringexamples.example04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPTest {
    @Autowired
    private AOPService04 aopService04;
    @Test
    public void test_getUser() {
        aopService04.getUser();
    }
    @Test
    public void test_getAdmin() {
        aopService04.getAdmin();
    }
}
