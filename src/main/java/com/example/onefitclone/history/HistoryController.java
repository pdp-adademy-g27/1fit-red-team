package com.example.onefitclone.history;
import com.example.onefitclone.history.dto.HistoryCreateDto;
import com.example.onefitclone.history.dto.HistoryResponseDto;
import com.example.onefitclone.history.dto.HistoryUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;
    @PostMapping
    public ResponseEntity<HistoryResponseDto> create(@RequestBody HistoryCreateDto createDto) {
        HistoryResponseDto responseDto = historyService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<HistoryResponseDto>> get(@RequestParam String predicate, Pageable pageable) {
        Page<HistoryResponseDto> all = historyService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryResponseDto> get(@PathVariable UUID id) {
        HistoryResponseDto responseDto = historyService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoryResponseDto> update(@PathVariable UUID id, @RequestBody HistoryUpdateDto updateDto) {
        HistoryResponseDto responseDto = historyService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HistoryResponseDto> delete(@PathVariable UUID id) {
        historyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
