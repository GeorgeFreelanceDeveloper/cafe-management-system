package com.example.cafemanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.mock;

@Configuration
public class Config {

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSender javaMailSender = mock(JavaMailSender.class);

        //TODO: defined mock functions

        return javaMailSender;
    }
}
