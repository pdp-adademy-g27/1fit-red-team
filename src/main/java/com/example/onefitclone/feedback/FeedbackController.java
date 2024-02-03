package com.example.onefitclone.feedback;

import com.example.onefitclone.feedback.dto.FeedbackCreateDto;
import com.example.onefitclone.feedback.dto.FeedbackResponseDto;
import com.example.onefitclone.feedback.dto.FeedbackUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;
    @PostMapping
    public ResponseEntity<FeedbackResponseDto> create(@RequestBody FeedbackCreateDto createDto) {
        FeedbackResponseDto responseDto = feedbackService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<FeedbackResponseDto>> get(@RequestParam String predicate, Pageable pageable) {
        Page<FeedbackResponseDto> all = feedbackService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackResponseDto> get(@PathVariable UUID id) {
        FeedbackResponseDto responseDto = feedbackService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackResponseDto> update(@PathVariable UUID id, @RequestBody FeedbackUpdateDto updateDto) {
        FeedbackResponseDto responseDto = feedbackService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeedbackResponseDto> delete(@PathVariable UUID id) {
        feedbackService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
