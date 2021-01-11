package com.example.springbootspringmvcexamples.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Address {
    private Integer id;
    private String detail;
    private String comment;
    private User user;
    private LocalDateTime insertTime;

    public Address(Integer id,String detail,String comment,LocalDateTime insertTime){
        this.id = id;
        this.comment = comment;
        this.detail = detail;
        this.insertTime = insertTime;
    }
}
