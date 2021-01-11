package com.example.springbootjpaexample.example09.pessimistic.service;

import com.example.springbootjpaexample.example09.pessimistic.entity.User09;
import com.example.springbootjpaexample.example09.pessimistic.repository.User09Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class User09Service {
    @Autowired
    private User09Repository user09Repository;

    public void addUser(User09 u){
        user09Repository.save(u);
    }

    public void buy(int balance,int id) {
        User09 u = user09Repository.list(1);
        int newBalance = u.getBalance() - balance;
        if (newBalance >=0 ){
            u.setBalance(newBalance);
            log.debug("支付成功,还剩余额为" + newBalance + "元");
        } else {
            log.debug("余额不足");
        }
    }
}
