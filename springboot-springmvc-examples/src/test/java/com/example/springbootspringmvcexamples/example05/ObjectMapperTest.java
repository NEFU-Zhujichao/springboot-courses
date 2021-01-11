package com.example.springbootspringmvcexamples.example05;


import com.example.springbootspringmvcexamples.example04.passwordencoder.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class ObjectMapperTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_json() throws JsonProcessingException {
        User user = new User();
        user.setUserName("chao");
        user.setPassword("123456");
        String json = objectMapper.writeValueAsString(user);
        log.debug(json);
        User u = objectMapper.readValue(json, User.class);
        log.debug(u.getUserName() + "/" + u.getPassword());
    }

    @Test
    public void test_json2() throws JsonProcessingException {

        User user = new User();
        user.setUserName("chao");
        user.setPassword("123456");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        String json = objectMapper.writeValueAsString(map);
        log.debug(json);
        Map<String, User> reMap = objectMapper.readValue(json, new TypeReference<Map<String, User>>() {
        });
        reMap.forEach((k, v) -> {
            log.debug(k);
            log.debug(v.getUserName() + "/" + v.getPassword());
        });
    }
}
