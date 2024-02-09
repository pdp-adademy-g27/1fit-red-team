package com.example.onefitclone.liked.dto;

import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikedResponseDto {
    private UUID id;
    private UUID courseId;
    private UUID userId;
    private User user;
    private Course course;
}
