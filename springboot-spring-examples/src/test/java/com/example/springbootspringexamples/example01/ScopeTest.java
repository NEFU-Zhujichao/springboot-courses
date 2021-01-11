package com.example.springbootspringexamples.example01;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ScopeTest {
    @Autowired
    private SingletonBean singletonBean;
    @Autowired
    private PrototypeBean prototypeBean;
    @Test
    public void test() {
        log.debug("prototype in test: {}",prototypeBean);
        log.debug("singleton in test: {}",singletonBean);
        prototypeBean.getSingle();
        singletonBean.getProto();
    }
}
