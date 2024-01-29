package com.example.onefitclone.studio.dto;


import com.example.onefitclone.studio.category.entity.Category;

import java.util.Set;
import java.util.UUID;

public class StudioResponseDto extends StudioDto{
    private UUID id;
    private Set<Category> categories;

}
