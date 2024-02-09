package com.example.onefitclone.course;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.course.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends GenericRepository<Course, UUID> {
}
