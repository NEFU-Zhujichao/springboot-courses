package com.example.springbootspringmvcexamples.config;


import com.example.springbootspringmvcexamples.example06.interceptor.interceptor.AdminInterceptor06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor06 adminInterceptor06;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor06)
                .addPathPatterns("/api/example06/admin/**");
    }
}
