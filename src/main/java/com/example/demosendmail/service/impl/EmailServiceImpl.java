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
    public String sendMessage(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@demo.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

        return "ok";
    }
}
