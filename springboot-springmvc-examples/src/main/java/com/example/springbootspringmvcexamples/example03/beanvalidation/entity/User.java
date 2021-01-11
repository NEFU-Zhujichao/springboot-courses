package com.example.springbootspringmvcexamples.example03.beanvalidation.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    @Size(min = 2,max = 6)
    private String name;
    @Max(value = 18)
    @Min(value = 60)
    private int age;
    @Email
    private String email;
}
