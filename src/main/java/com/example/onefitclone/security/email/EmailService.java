package com.example.onefitclone.security.email;

import com.example.onefitclone.common.exceptions.IncorrectPassword;
import com.example.onefitclone.common.exceptions.TimeOut;
import com.example.onefitclone.security.email.dto.EmailDto;
import com.example.onefitclone.security.email.dto.EmailRequestDto;
import com.example.onefitclone.user.UserRepository;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class EmailService {
    private final RedisTemplate<String, EmailDto> redisTemplate;
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final Random random = new Random();

    public void emailVerified(String  email) {
        userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Entity is not found by email: %s".formatted(email)));

        int code = random.nextInt(1000, 10000);
        notificationService.sendVerifyCode(email, code);
        EmailDto emailDto = new EmailDto(email, String.valueOf(code));
        redisTemplate.opsForValue().set(email, emailDto, 3, TimeUnit.MINUTES);
    }


    public String verified(EmailDto emailEntity) {
        EmailDto email = redisTemplate.opsForValue().get(emailEntity.getEmail());

        User user = userRepository.findByEmail(emailEntity.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Entity is not found by email: %s".formatted(email)));

        if (email != null) {
            if (email.getMessage().equals(emailEntity.getMessage())) {
                user.setVerify(true);
                return "Successfully verification";
            }
            throw new IncorrectPassword("Incorrect email verification");
        }
        throw new TimeOut("Time out");
    }


}
