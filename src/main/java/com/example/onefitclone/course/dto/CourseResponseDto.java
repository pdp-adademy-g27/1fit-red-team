package com.example.onefitclone.course.dto;

import com.example.onefitclone.comment.dto.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto extends CourseDto {
    private UUID id;
    private List<CommentResponseDto> comments;
    private String studioName;
}
