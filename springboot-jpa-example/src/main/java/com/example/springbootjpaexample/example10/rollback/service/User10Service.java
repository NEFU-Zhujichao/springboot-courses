package com.example.springbootjpaexample.example10.rollback.service;

import com.example.springbootjpaexample.example10.rollback.entity.User10;
import com.example.springbootjpaexample.example10.rollback.repository.User10Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
@Transactional
public class User10Service {
    @Autowired
    private User10Repository user10Repository;
    public void addUser(User10 u) {
        user10Repository.save(u);
        try {
            Files.readString(Path.of("A:/a.a"));
        } catch (IOException e) {
            throw new RuntimeException("run");
        }
    }

}
