package com.example.springbootexamples.component;

import com.example.springbootexamples.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "authorization";
    public static final String ROLE = "role";
    public static final String UID = "uid";
    private Integer uid;
    private User.Role role;
}
