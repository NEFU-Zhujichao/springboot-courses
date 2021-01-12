package com.example.springbootexamples.component;

import com.example.springbootexamples.entity.Teacher;
import com.example.springbootexamples.entity.User;
import com.example.springbootexamples.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitComponent implements InitializingBean {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        final int num = 1001;
        User user = userService.getUser(num);
        if (user == null) {
            User u = new User();
            u.setName("BO");
            u.setNumber(num);
            u.setRole(User.Role.TEACHER);
            u.setPassword(encoder.encode(String.valueOf(num)));
            Teacher t = new Teacher();
            t.setUser(u);
            userService.addTeacher(t);
        }
    }
}
