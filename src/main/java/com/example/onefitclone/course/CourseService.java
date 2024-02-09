package com.example.onefitclone.course;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.course.dto.CourseCreateDto;
import com.example.onefitclone.course.dto.CourseResponseDto;
import com.example.onefitclone.course.dto.CourseUpdateDto;
import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.studio.StudioRepository;
import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
@Transactional
public class CourseService extends GenericService<Course, UUID, CourseCreateDto, CourseResponseDto, CourseUpdateDto> {
    private final CourseRepository repository;
    private final StudioRepository studioRepository;
    private final Class<Course> entityClass = Course.class;
    private final CourseDtoMapper mapper;

    @Override
    protected CourseResponseDto internalCreate(CourseCreateDto courseCreateDto) {
        Course course = mapper.toEntity(courseCreateDto);
        String startTimeString = courseCreateDto.getStartTime();
        String endTimeString = courseCreateDto.getEndTime();

        LocalDateTime startTime = LocalDateTime.parse(startTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm"));
        LocalDateTime endTime = LocalDateTime.parse(endTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm"));

        UUID studioId = courseCreateDto.getStudioId();
        Studio studio = studioRepository.findById(studioId).orElseThrow(() -> new EntityNotFoundException("Studio not found"));

        studio.getCourses().add(course);
        course.setStudio(studio);
        course.setStartTime(startTime);
        course.setEndTime(endTime);
        course.setId(UUID.randomUUID());

        studioRepository.save(studio);

        Course saved = repository.save(course);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected CourseResponseDto internalUpdate(UUID uuid, CourseUpdateDto courseUpdateDto) {
        return null;
    }
}
