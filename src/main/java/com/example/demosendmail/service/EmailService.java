package com.example.demosendmail.service;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    String sendMessage(String to, String subject, String content, MultipartFile... attachFile) throws MessagingException;
}
