package com.example.springbootjpaexample.example05;

import com.example.springbootjpaexample.example05.entity.User05;
import com.example.springbootjpaexample.example05.repository.User05Repository;
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
public class User05RepositoryTest {
    @Autowired
    private User05Repository user05Repository;
    @Autowired
    private EntityManager manager;
    @Test
    public void test_addUser() {
        User05 user = new User05();
        user.setName("Chao");
        user05Repository.save(user);
        user.setName("QI");
    }
    @Test
    public void test_addUser2() {
        User05 user = user05Repository.findById(2).orElse(null);
        user.setName("chao");
    }
    @Test
    public void test_addUser3() {
        User05 user = new User05();
        user.setId(1);
        user05Repository.save(user);
    }
    @Test
    public void test_addUser4() {
        User05 user = new User05();
        user.setName("zhangsiqi");
        user05Repository.save(user);
        log.debug("{}",user.getId());
        log.debug("{}",user.getInsertTime());
    }
    @Test
    public void test_refresh() {
        User05 user = new User05();
        user.setName("zhujichao");
        manager.persist(user);
        manager.refresh(user);
        log.debug("{}",user.getId());
        log.debug("{}",user.getInsertTime());
    }
    @Test
    public void test_refresh2() {
        User05 user = new User05();
        user.setName("wang");
        user05Repository.save(user);
        user05Repository.refresh(user);
        log.debug("{}",user.getId());
        log.debug("{}",user.getInsertTime());
    }
}
