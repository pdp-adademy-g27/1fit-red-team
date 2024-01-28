package com.example.onefitclone.comment;

import com.example.onefitclone.comment.dto.CommentCreateDto;
import com.example.onefitclone.comment.dto.CommentResponseDto;
import com.example.onefitclone.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> create(@RequestBody CommentCreateDto createDto) {
        CommentResponseDto responseDto = commentService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<CommentResponseDto>> get(@RequestParam String predicate, Pageable pageable) {
        Page<CommentResponseDto> all = commentService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> get(@PathVariable UUID id) {
        CommentResponseDto responseDto = commentService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> update(@PathVariable UUID id, @RequestBody CommentUpdateDto updateDto) {
        CommentResponseDto responseDto = commentService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentResponseDto> delete(@PathVariable UUID id) {
        commentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
