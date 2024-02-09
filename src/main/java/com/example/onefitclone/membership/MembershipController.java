package com.example.onefitclone.membership;

import com.example.onefitclone.membership.dto.MembershipCreateDto;
import com.example.onefitclone.membership.dto.MembershipResponseDto;
import com.example.onefitclone.membership.dto.MembershipUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/membership")
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipService service;

    @PostMapping
    public ResponseEntity<MembershipResponseDto> create(@RequestBody @Valid MembershipCreateDto createDto) {
        MembershipResponseDto responseDto = service.create(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<MembershipResponseDto>> get(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<MembershipResponseDto> all = service.getAll(predicate, pageable);
        return ResponseEntity
                .ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipResponseDto> get(@PathVariable UUID id) {
        MembershipResponseDto responseDto = service.get(id);
        return ResponseEntity
                .ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipResponseDto> update(@PathVariable UUID id, @RequestBody MembershipUpdateDto updateDto) {
        MembershipResponseDto responseDto = service.update(id, updateDto);
        return ResponseEntity
                .ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MembershipResponseDto> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
