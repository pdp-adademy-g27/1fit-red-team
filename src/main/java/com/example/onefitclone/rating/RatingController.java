package com.example.onefitclone.rating;

import com.example.onefitclone.rating.dto.RatingCreateDto;
import com.example.onefitclone.rating.dto.RatingResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rating")
@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingResponseDto> create(@RequestBody @Valid RatingCreateDto createDto) {
        RatingResponseDto ratingResponseDto = ratingService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<RatingResponseDto>> get(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<RatingResponseDto> all = ratingService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }
}
