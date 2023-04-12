package com.example.demosendmail.controller;

import com.example.demosendmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class SendMailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendMail() {
        try {
            return emailService.sendMessage("Demo");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
