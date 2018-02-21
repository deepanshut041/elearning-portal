package com.example.sawdhyay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.sawdhyay")
@EntityScan(basePackages = {"com.example.sawdhyay.models"})
public class AppConfig {
    public static void main(String args[]){
        SpringApplication.run(AppConfig.class, args);
    }
}
