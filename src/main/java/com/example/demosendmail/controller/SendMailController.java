package com.example.demosendmail.controller;

import com.example.demosendmail.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
@Slf4j
public class SendMailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String content) {
        try {
            return emailService.sendMessage(to, subject, content);
        } catch (Exception e) {
            log.error("Send mail: " + e);
            return e.getMessage();
        }
    }
}
