package com.example.springbootspringmvcexamples.example04.passwordencoder.service;

import com.example.springbootspringmvcexamples.example04.passwordencoder.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class UserService04 {
    private Map<String, User> map = create();

    private Map<String, User> create(){
        User u = new User();
        u.setUserName("chao");
        u.setPassword("$2a$10$R454Ui75NX0R8CU9Y9E7GuYfho4ukaCj2blLGCYojyJ8FB2WDI19q");
        return Map.of("chao",u);
    }

    public User getUser(String userName){
        return map.get(userName);
    }
}
