package com.example.demosendmail.service;

public interface EmailService {
    String sendMessage(String to, String subject, String content);
}
