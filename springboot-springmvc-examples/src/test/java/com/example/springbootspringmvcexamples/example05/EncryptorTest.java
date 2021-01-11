package com.example.springbootspringmvcexamples.example05;

import com.example.springbootspringmvcexamples.example05.textencryptor.component.MyToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@SpringBootTest
@Slf4j
public class EncryptorTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Value("${my.secretkey}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;

    @Test
    public void test_encrypt() throws JsonProcessingException {
        MyToken token = new MyToken();
        token.setUid(1);
        token.setRole(MyToken.Role.ADMIN);
        TextEncryptor encryptor = Encryptors.text(secretKey,salt);
        String json = objectMapper.writeValueAsString(token);
        String result = encryptor.encrypt(json);
        log.debug(result);
        log.debug(String.valueOf(result.length()));
        log.debug(encryptor.encrypt(json));

        String json2 = encryptor.decrypt(result);
        MyToken myToken = objectMapper.readValue(json2, MyToken.class);
        log.debug(myToken.getRole().toString());
        log.debug(myToken.getUid().toString());
    }
}
