package com.example.springbootjpaexample.example08;

import com.example.springbootjpaexample.example09.pessimistic.entity.User09;
import com.example.springbootjpaexample.example09.pessimistic.service.User09Service;
import com.jayway.jsonpath.spi.json.TapestryJsonProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PessimisticTest {
    @Autowired
    private User09Service user09Service;
    @Test
    public void test_addUser(){
        User09 u = new User09();
        u.setBalance(1000);
        u.setName("chao");
        user09Service.addUser(u);
    }
    @Test
    public void test_buy(){
        new Thread(() -> {
            user09Service.buy(800,1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            user09Service.buy(800,1);
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
