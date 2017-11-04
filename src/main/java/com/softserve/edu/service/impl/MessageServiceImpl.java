package com.softserve.edu.service.impl;

import com.softserve.edu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private JavaMailSender mailSender;

    @Autowired
    public void setMailSender(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }

    @Override
    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    @Override
    public void sendMessageWithTemplate(String template) {

    }
}
