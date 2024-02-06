package com.example.onefitclone.location;

import com.example.onefitclone.location.dto.LocationCreateDto;
import com.example.onefitclone.location.dto.LocationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService service;

    @PostMapping
    public ResponseEntity<LocationResponseDto> create(@RequestBody @Valid LocationCreateDto locationDto) {
        LocationResponseDto locationResponseDto = service.create(locationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<LocationResponseDto>> get(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<LocationResponseDto> locationResponseDtos = service.getAll(predicate, pageable);
        return ResponseEntity.ok(locationResponseDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationResponseDto> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
