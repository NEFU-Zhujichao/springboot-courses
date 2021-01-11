package com.example.springbootjpaexample;

import com.example.springbootjpaexample.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class SpringbootJpaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaExampleApplication.class, args);
    }

}
