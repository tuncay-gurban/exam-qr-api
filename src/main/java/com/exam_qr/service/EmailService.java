package com.exam_qr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendQRCode(String toEmail, String qrBase64){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setFrom("tuncaygurban@gmail.com");
        message.setSubject("Second Exam QR Code");
        message.setText("Your QR code: " + qrBase64);
        mailSender.send(message);
    }
}
