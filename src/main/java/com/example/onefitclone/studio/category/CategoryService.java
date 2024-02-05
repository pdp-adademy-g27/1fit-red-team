package com.example.onefitclone.studio.category;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.studio.StudioRepository;
import com.example.onefitclone.studio.category.dto.CategoryCreateDto;
import com.example.onefitclone.studio.category.dto.CategoryResponseDto;
import com.example.onefitclone.studio.category.dto.CategoryUpdateDto;
import com.example.onefitclone.studio.category.entity.Category;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Getter
@RequiredArgsConstructor
public class CategoryService extends GenericService<Category, String, CategoryCreateDto, CategoryResponseDto, CategoryUpdateDto> {
    private final CategoryRepository repository;
    private final StudioRepository studioRepository;
    private final Class<Category> entityClass = Category.class;
    private final CategoryDtoMapper mapper;

    @Override
    protected CategoryResponseDto internalCreate(CategoryCreateDto categoryCreateDto) {
        Category entity = mapper.toEntity(categoryCreateDto);
        Category saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected CategoryResponseDto internalUpdate(String id, CategoryUpdateDto categoryUpdateDto) {
        Category category = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category not found")
                );
        mapper.toEntity(categoryUpdateDto, category);
        Category saved = repository.save(category);
        return mapper.toResponseDto(saved);
    }

}
