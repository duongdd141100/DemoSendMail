package com.example.demosendmail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailSenderConfig {
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);

        mailSender.setUsername("vangdau344@gmail.com");
        mailSender.setPassword("");

        Properties props = mailSender.getJavaMailProperties();
        props.setProperty("mail.smtp.auth", "true");

        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        return mailSender;
    }
}
