package com.example.springbootspringmvcexamples.example05;

import com.example.springbootspringmvcexamples.example05.textencryptor.component.EncryptComponent05;
import com.example.springbootspringmvcexamples.example05.textencryptor.component.MyToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TextEncryptorTest {
    @Autowired
    private EncryptComponent05 encryptor;

    @Test
    public void test_encrypt(){
        MyToken token = new MyToken();
        token.setUid(1);
        token.setRole(MyToken.Role.ADMIN);
        String json = encryptor.encryptToken(token);
        log.debug(json);
        MyToken myToken = encryptor.decryptToken(json);
        log.debug(myToken.getUid().toString());
        log.debug(myToken.getRole().toString());
        log.debug(encryptor.decryptToken(encryptor.encryptToken(token)).getRole().toString());
    }
}
