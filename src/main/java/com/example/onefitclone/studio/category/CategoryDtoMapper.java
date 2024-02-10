package com.example.onefitclone.studio.category;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.studio.category.dto.CategoryCreateDto;
import com.example.onefitclone.studio.category.dto.CategoryResponseDto;
import com.example.onefitclone.studio.category.dto.CategoryUpdateDto;
import com.example.onefitclone.studio.category.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor

public class CategoryDtoMapper extends GenericMapper<Category, CategoryCreateDto, CategoryResponseDto, CategoryUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Category toEntity(CategoryCreateDto categoryCreateDto) {
        return mapper.map(categoryCreateDto, Category.class);
    }

    @Override
    public CategoryResponseDto toResponseDto(Category category) {

        return mapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public void toEntity(CategoryUpdateDto categoryUpdateDto, Category category) {
        mapper.map(categoryUpdateDto, category);
    }
}
