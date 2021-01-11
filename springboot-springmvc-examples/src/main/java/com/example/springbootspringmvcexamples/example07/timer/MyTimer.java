package com.example.springbootspringmvcexamples.example07.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyTimer {
    // 分 秒 时 日 月 星期
    // ,->and /增幅 -区间 ?占位 *通配符
    @Scheduled(cron = "*/3 * * * * *")
    public void getSalary(){
        log.debug("you have salary");
    }
}
