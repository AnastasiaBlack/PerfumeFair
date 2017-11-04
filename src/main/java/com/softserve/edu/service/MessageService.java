package com.softserve.edu.service;

public interface MessageService {
    void sendMessage(String to, String subject, String text);
    void sendMessageWithTemplate(String template);
}
