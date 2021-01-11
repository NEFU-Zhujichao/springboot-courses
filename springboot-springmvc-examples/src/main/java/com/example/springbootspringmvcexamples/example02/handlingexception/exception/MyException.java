package com.example.springbootspringmvcexamples.example02.handlingexception.exception;

public class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}
