package com.example.springbootspringexamples.example04;

import org.springframework.stereotype.Component;

@Component
@MyAuthority
public class AOPService04 {
    public void getUser() {

    }
    @MyAuthority({MyAuthority.MyAuthorityType.ADMIN, MyAuthority.MyAuthorityType.SUPERADMIN})
    public void getAdmin() {

    }
}
