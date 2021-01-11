package com.example.springbootjpaexample.example08.service;

import com.example.springbootjpaexample.example08.entity.User08;
import com.example.springbootjpaexample.example08.repository.User08Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class User08Service {
    @Autowired
    private User08Repository user08Repository;
    public void addUser(User08 user) {
        user08Repository.save(user);
    }
    public void updateUser(int id,String name) {
        user08Repository.findById(id).orElse(null).setName(name);
    }
}
