package com.RadhaMounika.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmtpEmailService {
    @Value("${spring.mail.username}")
    private String fromUsername;

    @Value("${spring.mail.subject}")
    private String subject;

    private final JavaMailSender mailSender;

    public void sendEmail(String to, String body) {
        log.info("Sending email to " + to);
        org.springframework.mail.SimpleMailMessage message = new org.springframework.mail.SimpleMailMessage();
        message.setFrom(fromUsername);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
