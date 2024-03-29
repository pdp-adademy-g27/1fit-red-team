package com.example.onefitclone.studio;

import com.example.onefitclone.studio.dto.StudioCreateDto;
import com.example.onefitclone.studio.dto.StudioResponseDto;
import com.example.onefitclone.studio.dto.StudioUpdateDto;
import jakarta.validation.Valid;
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
@RequestMapping("/studio")
public class StudioController {
    private final StudioService studioService;
    @PreAuthorize("hasAnyAuthority('studio:create')")
    @PostMapping
    public ResponseEntity<StudioResponseDto> create(@RequestBody @Valid StudioCreateDto createDto) {
        StudioResponseDto responseDto = studioService.create(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @PreAuthorize("hasAnyAuthority('studio:read')")
    @GetMapping
    public ResponseEntity<Page<StudioResponseDto>> get(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<StudioResponseDto> all = studioService.getAll(predicate, pageable);
        return ResponseEntity
                .ok(all);
    }

    @PreAuthorize("hasAnyAuthority('studio:read')")
    @GetMapping("/{id}")
    public ResponseEntity<StudioResponseDto> get(@PathVariable UUID id) {
        StudioResponseDto responseDto = studioService.get(id);
        return ResponseEntity
                .ok(responseDto);
    }

    @PreAuthorize("hasAnyAuthority('studio:update')")
    @PutMapping("/{id}")
    public ResponseEntity<StudioResponseDto> update(@PathVariable UUID id, @RequestBody StudioUpdateDto updateDto) {
        StudioResponseDto responseDto = studioService.update(id, updateDto);
        return ResponseEntity
                .ok(responseDto);
    }

    @PreAuthorize("hasAnyAuthority('studio:delete')")
    @DeleteMapping("/{id}")
    public ResponseEntity<StudioResponseDto> delete(@PathVariable UUID id) {
        studioService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PreAuthorize("hasAnyAuthority('studio:add-category')")
    @PostMapping("/{id}/add/category/{name}")
    public ResponseEntity<StudioResponseDto> addCategory(@PathVariable UUID id, @PathVariable String name){
        StudioResponseDto studioResponseDto = studioService.addCategory(id, name);
        return ResponseEntity.ok(studioResponseDto);
    }

}
