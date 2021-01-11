package com.example.springbootjpaexample.example06.service;

import com.example.springbootjpaexample.example06.entity.Adress06;
import com.example.springbootjpaexample.example06.entity.User06;
import com.example.springbootjpaexample.example06.repository.Adress06Repository;
import com.example.springbootjpaexample.example06.repository.User06Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class User06Service {
    @Autowired
    private User06Repository user06Repository;
    @Autowired
    private Adress06Repository adress06Repository;
    public void addUser(User06 user06) {
        user06Repository.save(user06);
    }
    public void addAdress(Adress06 adress06) {
        adress06Repository.save(adress06);
    }
    public User06 getUser(int id) {
        User06 u = user06Repository.findById(id).orElse(null);
        u.getAdresses().forEach(x -> log.debug(x.getDetail()));
        return u;
    }
    public Adress06 getAdress(int id) {
        return adress06Repository.findById(id).orElse(null);
    }
}
