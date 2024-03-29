package com.example.onefitclone.studio.dto;

import com.example.onefitclone.location.dto.LocationResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioResponseDtoForCategory extends StudioDto{
    private UUID id;
    private LocationResponseDto location;
}
