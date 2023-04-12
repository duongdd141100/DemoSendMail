package com.example.demosendmail.service.impl;

import com.example.demosendmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendMessage(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@demo.com");
        message.setTo("duongdd141100@gmail.com");
        message.setSubject("Demo Subject");
        message.setText(text);
        mailSender.send(message);

        return "ok";
    }
}
