package com.example.onefitclone.security.sms;

public interface SmsNotificationService {
    void sendNotification(String phoneNumber, String message);
}
