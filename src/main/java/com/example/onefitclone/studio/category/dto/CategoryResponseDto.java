package com.example.onefitclone.studio.category.dto;

import com.example.onefitclone.studio.dto.StudioResponseDto;
import com.example.onefitclone.studio.entity.Studio;

import java.util.Set;

public class CategoryResponseDto extends CategoryDto{
    private Set<StudioResponseDto> studios;
}
