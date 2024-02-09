package com.example.onefitclone.comment;

import com.example.onefitclone.comment.dto.CommentCreateDto;
import com.example.onefitclone.comment.dto.CommentResponseDto;
import com.example.onefitclone.comment.dto.CommentUpdateDto;
import com.example.onefitclone.comment.entity.Comment;
import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.course.CourseRepository;
import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.user.UserRepository;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
@Transactional
public class CommentService extends GenericService<Comment, UUID, CommentCreateDto, CommentResponseDto, CommentUpdateDto> {
    private final CommentRepository repository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final Class<Comment> entityClass = Comment.class;
    private final CommentDtoMapper mapper;


    @Override
    protected CommentResponseDto internalCreate(CommentCreateDto commentCreateDto) {
        Comment comment = mapper.toEntity(commentCreateDto);

        UUID courseId = commentCreateDto.getCourseId();
        UUID userId = commentCreateDto.getUserId();

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        course.getComments().add(comment);
        comment.setCourse(course);
        comment.setId(UUID.randomUUID());
        comment.setUser(user);

        userRepository.save(user);
        Comment saved = repository.save(comment);

        return mapper.toResponseDto(saved);
    }

    @Override
    protected CommentResponseDto internalUpdate(UUID uuid, CommentUpdateDto commentUpdateDto) {
        Comment comment = repository
                .findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException("Comment not found")
                );
        mapper.toEntity(commentUpdateDto, comment);
        Comment saved = repository.save(comment);
        return mapper.toResponseDto(saved);
    }
}
