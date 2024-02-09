package com.example.onefitclone.course;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.course.dto.CourseCreateDto;
import com.example.onefitclone.course.dto.CourseResponseDto;
import com.example.onefitclone.course.dto.CourseUpdateDto;
import com.example.onefitclone.course.entity.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class CourseDtoMapper extends GenericMapper<Course, CourseCreateDto, CourseResponseDto, CourseUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Course toEntity(CourseCreateDto courseCreateDto) {
        return mapper.map(courseCreateDto, Course.class);
    }

    @Override
    public CourseResponseDto toResponseDto(Course course) {
        CourseResponseDto responseDto = mapper.map(course, CourseResponseDto.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        LocalDateTime startTime = course.getStartTime();
        LocalDateTime endTime = course.getEndTime();
        String startTimeString = startTime.format(formatter);
        String endTimeString = endTime.format(formatter);

        String studioName = course.getStudio().getName();

        responseDto.setStartTime(startTimeString);
        responseDto.setEndTime(endTimeString);
        responseDto.setStudioName(studioName);

        return responseDto;
    }


    @Override
    public void toEntity(CourseUpdateDto courseUpdateDto, Course course) {
        mapper.map(courseUpdateDto, course);
    }
}
