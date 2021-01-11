package com.example.springbootjpaexample.example07;

import com.example.springbootjpaexample.example07.entity.Address07;
import com.example.springbootjpaexample.example07.entity.User07;
import com.example.springbootjpaexample.example07.repository.Address07Repository;
import com.example.springbootjpaexample.example07.repository.User07Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;


@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private User07Repository user07Repository;
    @Autowired
    private Address07Repository address07Repository;
    @Transactional
    @Rollback(value = false)
    @Test
    public void init(){
        User07 u = new User07();
        u.setName("chao");
        user07Repository.save(u);
        User07 u2 = new User07();
        u2.setName("qi");
        user07Repository.save(u2);
        Address07 a = new Address07();
        a.setDetail("内蒙古");
        a.setUser(u);
        address07Repository.save(a);
        Address07 a2 = new Address07();
        a2.setDetail("哈尔滨");
        a2.setUser(u2);
        address07Repository.save(a2);
        Address07 a3 = new Address07();
        a3.setDetail("乌兰浩特");
        a3.setUser(u);
        address07Repository.save(a3);
    }
    @Test
    public void test_listUsers() {
        user07Repository.list("qi").forEach(x -> log.debug("{}",x.getId()));
    }
    @Test
    public void test_listDetails() {
        address07Repository.list(1)
                .forEach(x -> log.debug(x.getDetail()));
    }
    @Test
    public void find_User(){
        user07Repository.findByName("qi").forEach(x -> log.debug("{}",x.getId()));
    }
    /*@Test
    public void test_pageAble() {
        address07Repository.list("乌兰浩特",PageRequest.of(0,20))
                .getContent()
                .forEach(x -> log.debug("{}",x.getUser().getName()));
    }*/
    @Test
    @Transactional
    @Rollback(value = false)
    //查询不涉及持久化操作不需要事务，但是更新需要持久化操作，需要加上事务
    public void test_update() {
        user07Repository.update("hello",1);
    }
}
