package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatTest {

    @Bean
    public Cat cat(){
        return new Cat("tom","18");
    }
}
