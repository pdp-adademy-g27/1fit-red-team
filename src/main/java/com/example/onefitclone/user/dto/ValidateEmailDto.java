package com.example.onefitclone.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ValidateEmailDto {
    @NotBlank
    @Column(nullable = false)
    private String email;
    private Integer otp;
}
