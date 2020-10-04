package com.example.springbootjpaexample.example01;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class UserTest {
    @Autowired
    private EntityManager manager;
    @Test
    public void test_User(){
        User user = new User();
        user.setName("chao");
        user.setBirthday(LocalDate.of(2000,10,3));
        manager.persist(user);
        log.debug("{}",user.getId());
    }

}
