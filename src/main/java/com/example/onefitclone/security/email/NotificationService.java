package com.example.onefitclone.security.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender javaMailSender;

    public void sendVerifyCode(String email,int code) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("hsopoyev11@gmail.com");
            message.setTo(email);
            message.setSubject("qwerty");
            message.setText(String.valueOf(code));
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void forgetPassword(String email, String url) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("hsopoyev11@gmail.com");
            message.setTo(email);
            message.setSubject("qwerty");
            message.setText(url);
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
