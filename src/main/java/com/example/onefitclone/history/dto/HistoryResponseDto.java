package com.example.onefitclone.history.dto;
import com.example.onefitclone.course.dto.CourseResponseDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponseDto extends HistoryDto {
    private UUID id;
    private UserResponseDto user;
    private CourseResponseDto course;
}
