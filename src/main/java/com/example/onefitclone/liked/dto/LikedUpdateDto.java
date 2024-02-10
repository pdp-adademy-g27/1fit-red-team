package com.example.onefitclone.liked.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikedUpdateDto {
    private UUID courseId;
    private UUID userId;
}
