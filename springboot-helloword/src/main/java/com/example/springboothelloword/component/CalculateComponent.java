package com.example.springboothelloword.component;

import org.springframework.stereotype.Component;

@Component
public class CalculateComponent {
    public int add(int x, int y){
        return x + y;
    }
}
