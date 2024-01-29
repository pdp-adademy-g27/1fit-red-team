package com.example.onefitclone.comment;

import com.example.onefitclone.comment.dto.CommentCreateDto;
import com.example.onefitclone.comment.dto.CommentResponseDto;
import com.example.onefitclone.comment.dto.CommentUpdateDto;
import com.example.onefitclone.comment.entity.Comment;
import com.example.onefitclone.common.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class CommentService extends GenericService<Comment, UUID, CommentCreateDto, CommentResponseDto, CommentUpdateDto> {
    private final CommentRepository repository;
    private final Class<Comment> entityClass = Comment.class;
    private final CommentDtoMapper mapper;


    @Override
    protected CommentResponseDto internalCreate(CommentCreateDto commentCreateDto) {
        Comment comment = mapper.toEntity(commentCreateDto);
        comment.setId(UUID.randomUUID());
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
