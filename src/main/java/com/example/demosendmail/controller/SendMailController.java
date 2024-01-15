package com.example.demosendmail.controller;

import com.example.demosendmail.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/mail")
@Slf4j
public class SendMailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/send", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String sendMail(@RequestPart String to,
                           @RequestPart String subject,
                           @RequestPart String content,
                           @RequestPart MultipartFile... attachFile) {
        try {
            return emailService.sendMessage(to, subject, content, attachFile);
        } catch (Exception e) {
            log.error("Send mail: " + e);
            return e.getMessage();
        }
    }
}
