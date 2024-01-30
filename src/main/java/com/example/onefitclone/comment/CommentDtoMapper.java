package com.example.onefitclone.comment;

import com.example.onefitclone.comment.dto.CommentCreateDto;
import com.example.onefitclone.comment.dto.CommentResponseDto;
import com.example.onefitclone.comment.dto.CommentUpdateDto;
import com.example.onefitclone.comment.entity.Comment;
import com.example.onefitclone.common.mapper.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDtoMapper extends GenericMapper<Comment, CommentCreateDto, CommentResponseDto, CommentUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Comment toEntity(CommentCreateDto commentCreateDto) {
        return mapper.map(commentCreateDto, Comment.class);
    }

    @Override
    public CommentResponseDto toResponseDto(Comment comment) {

        return mapper.map(comment, CommentResponseDto.class);
    }

    @Override
    public void toEntity(CommentUpdateDto commentUpdateDto, Comment comment) {

        mapper.map(commentUpdateDto, comment);
    }
}
