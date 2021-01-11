package com.example.springbootjpaexample.example06;

import com.example.springbootjpaexample.example06.entity.Adress06;
import com.example.springbootjpaexample.example06.entity.User06;
import com.example.springbootjpaexample.example06.repository.User06Repository;
import com.example.springbootjpaexample.example06.service.User06Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class User06ServiceTest {
    @Autowired
    private User06Service user06Service;
    @Test
    public void init(){
        User06 user = new User06();
        user.setName("chao");
        user06Service.addUser(user);
        Adress06 adress = new Adress06();
        adress.setDetail("内蒙古");
        adress.setUser(user);
        user06Service.addAdress(adress);
        Adress06 adress2 = new Adress06();
        adress2.setDetail("哈尔滨");
        adress2.setUser(user);
        user06Service.addAdress(adress2);
    }
    @Test
    public void test_fatch() {
        log.debug(user06Service.getAdress(1).getUser().getName());
    }
    @Test
    public void test_fatch2() {
        /*在many端延迟加载，解决方法：
        1.在逻辑操作层调用方法
        2.在many端加上 fetch = FetchType.EAGER
         */
        user06Service.getUser(1);
        //user06Service.getUser(1).getAdresses().forEach(x -> log.debug(x.getDetail()));
    }
}
