package com.example.onefitclone.user.permission.dto;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResponseDto {
    private String name;
}
