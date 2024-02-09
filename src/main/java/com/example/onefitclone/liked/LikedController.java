package com.example.onefitclone.liked;
import com.example.onefitclone.liked.dto.LikedCreateDto;
import com.example.onefitclone.liked.dto.LikedResponseDto;
import com.example.onefitclone.liked.dto.LikedUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/liked")
@RequiredArgsConstructor
public class LikedController {
    private final LikedService likedService;
    @PostMapping
    public ResponseEntity<LikedResponseDto> create(@RequestBody LikedCreateDto createDto) {
        LikedResponseDto responseDto = likedService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<LikedResponseDto>> get(@RequestParam String predicate, Pageable pageable) {
        Page<LikedResponseDto> all = likedService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikedResponseDto> get(@PathVariable UUID id) {
        LikedResponseDto responseDto = likedService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LikedResponseDto> update(@PathVariable UUID id, @RequestBody LikedUpdateDto updateDto) {
        LikedResponseDto responseDto = likedService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LikedResponseDto> delete(@PathVariable UUID id) {
        likedService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
