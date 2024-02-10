package com.example.onefitclone.liked.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikedCreateDto {
   private UUID userId;
   private UUID courseId;
}
