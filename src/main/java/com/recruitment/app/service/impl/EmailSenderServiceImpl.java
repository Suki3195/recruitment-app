package com.recruitment.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailSenderServiceImpl {

    @Autowired
    private JavaMailSender mailSender;


    @Value("${email.from}")
    private String emailFrom;

    public void sendMail (String pw){

        log.info("About to send Mail");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo("sukirtisingh3195@gmail.com");
        message.setSubject("Recruitment App Test Mail");
        message.setText("Dear Receiver, Your Password is  :   {}  " +  pw  + " . Kindly reset Your Password");

        mailSender.send(message);
        log.info("Mail Sent Successfully");




    }}
