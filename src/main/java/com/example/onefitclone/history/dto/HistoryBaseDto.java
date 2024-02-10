package com.example.onefitclone.history.dto;

import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryBaseDto {
    private LocalDateTime whenComing;
    private LocalDateTime whenLeft;
    private User user;
    private Course course;
}
