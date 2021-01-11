package com.example.springbootjpaexample.example08;

import com.example.springbootjpaexample.example08.entity.User08;
import com.example.springbootjpaexample.example08.service.User08Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class OptimisticTest {
    @Autowired
    private User08Service user08Service;
    @Test
    public void test_addUser() {
        User08 u = new User08();
        u.setName("chao");
        user08Service.addUser(u);
    }
    @Test
    public void test_updateUser(){
        new Thread(() -> {
            user08Service.updateUser(1,"wang");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            user08Service.updateUser(1,"zhang");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
