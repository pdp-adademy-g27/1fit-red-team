package com.example.onefitclone.studio.category;

import com.example.onefitclone.studio.category.dto.CategoryCreateDto;
import com.example.onefitclone.studio.category.dto.CategoryResponseDto;
import com.example.onefitclone.studio.category.dto.CategoryUpdateDto;
import com.example.onefitclone.studio.dto.StudioCreateDto;
import com.example.onefitclone.studio.dto.StudioResponseDto;
import com.example.onefitclone.studio.dto.StudioUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryCreateDto createDto) {
        CategoryResponseDto responseDto = categoryService.create(createDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryResponseDto>> get(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<CategoryResponseDto> all = categoryService.getAll(predicate, pageable);
        return ResponseEntity
                .ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> get(@PathVariable String id) {
        CategoryResponseDto responseDto = categoryService.get(id);
        return ResponseEntity
                .ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable String id, @RequestBody CategoryUpdateDto updateDto) {
        CategoryResponseDto responseDto = categoryService.update(id, updateDto);
        return ResponseEntity
                .ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> delete(@PathVariable String id) {
        categoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
