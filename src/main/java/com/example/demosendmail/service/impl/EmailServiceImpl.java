package com.example.demosendmail.service.impl;

import com.example.demosendmail.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sendMessage(String to, String subject, String content, MultipartFile attachFile) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("noreply@demo.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.addAttachment("AttachFile.png", attachFile);
        helper.setText(content);
        mailSender.send(message);

        return "ok";
    }
}
