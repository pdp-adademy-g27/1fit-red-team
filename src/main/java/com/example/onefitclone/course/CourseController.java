package com.example.onefitclone.course;

import com.example.onefitclone.course.dto.CourseCreateDto;
import com.example.onefitclone.course.dto.CourseResponseDto;
import com.example.onefitclone.course.dto.CourseUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;

    @PreAuthorize("hasAnyAuthority('course:create')")
    @PostMapping
    public ResponseEntity<CourseResponseDto> create(@RequestBody CourseCreateDto courseCreateDto) {
        CourseResponseDto courseResponseDto = service.create(courseCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseResponseDto);
    }

    @PreAuthorize("hasAnyAuthority('course:read')")
    @GetMapping
    public ResponseEntity<Page<CourseResponseDto>> get(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<CourseResponseDto> all = service.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @PreAuthorize("hasAnyAuthority('course:read')")
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> get(@PathVariable UUID id) {
        CourseResponseDto courseResponseDto = service.get(id);
        return ResponseEntity.ok(courseResponseDto);
    }

    @PreAuthorize("hasAnyAuthority('course:update')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> update(@PathVariable UUID id, @RequestBody CourseUpdateDto updateDto) {
        CourseResponseDto courseResponseDto = service.update(id, updateDto);
        return ResponseEntity.ok(courseResponseDto);
    }

    @PreAuthorize("hasAnyAuthority('course:delete')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CourseResponseDto> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
