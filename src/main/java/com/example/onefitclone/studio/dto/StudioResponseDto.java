package com.example.onefitclone.studio.dto;


import com.example.onefitclone.location.dto.LocationResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.example.onefitclone.studio.category.dto.CategoryResponseDto;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioResponseDto extends StudioDto{
    private UUID id;
    private LocationResponseDto location;
}
