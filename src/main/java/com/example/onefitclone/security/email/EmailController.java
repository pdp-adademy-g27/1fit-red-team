package com.example.onefitclone.security.email;

import com.example.onefitclone.security.email.dto.EmailDto;
import com.example.onefitclone.security.email.dto.EmailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/emilVerified")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> emailVerified(@RequestParam String email) {
        emailService.emailVerified(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/verification")
    public String getVerification(@RequestBody EmailDto email){
        return emailService.verified(email);
    }


}