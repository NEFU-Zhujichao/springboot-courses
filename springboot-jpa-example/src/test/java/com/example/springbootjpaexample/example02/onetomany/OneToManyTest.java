package com.example.springbootjpaexample.example02.onetomany;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class OneToManyTest {
    @Autowired
    private EntityManager manager;
    @Test
    public void test_rel() {
        User02 u = manager.find(User02.class,1);
        Adress02 adress = manager.find(Adress02.class,1);
        Adress02 adress02 = manager.find(Adress02.class,2);
        adress.setUser(u);
        adress02.setUser(u);
        adress.setDetail("内蒙古");
        adress02.setDetail("哈尔滨");
    }
    @Test
    public void test_rel2() {

    }
}
