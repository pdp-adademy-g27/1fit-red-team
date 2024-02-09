package com.example.onefitclone.studio.category.dto;

import com.example.onefitclone.studio.dto.StudioResponseDtoForCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto extends CategoryDto {
    private List<StudioResponseDtoForCategory> studios;
}
