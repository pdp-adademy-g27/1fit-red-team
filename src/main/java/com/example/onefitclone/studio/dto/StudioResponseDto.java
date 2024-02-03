package com.example.onefitclone.studio.dto;


import com.example.onefitclone.studio.category.dto.CategoryResponseDto;

import java.util.Set;
import java.util.UUID;

public class StudioResponseDto extends StudioDto{
    private UUID id;
    private Set<CategoryResponseDto> categories;

}
