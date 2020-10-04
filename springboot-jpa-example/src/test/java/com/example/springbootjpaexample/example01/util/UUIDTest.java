package com.example.springbootjpaexample.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;
@Slf4j
public class UUIDTest {
    @Test
    public void test_uuid(){
        UUID uuid = UUID.randomUUID();
        log.debug("{}", uuid);
    }
}
