package com.example.onefitclone.comment;

import com.example.onefitclone.comment.dto.CommentCreateDto;
import com.example.onefitclone.comment.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PreAuthorize("hasAnyAuthority('comment:create')")
    @PostMapping
    public ResponseEntity<CommentResponseDto> create(@RequestBody CommentCreateDto createDto) {
        CommentResponseDto responseDto = commentService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PreAuthorize("hasAnyAuthority('comment:read')")
    @GetMapping
    public ResponseEntity<Page<CommentResponseDto>> get(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<CommentResponseDto> all = commentService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @PreAuthorize("hasAnyAuthority('comment:read')")
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> get(@PathVariable UUID id) {
        CommentResponseDto responseDto = commentService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PreAuthorize("hasAnyAuthority('comment:delete')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentResponseDto> delete(@PathVariable UUID id) {
        commentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
