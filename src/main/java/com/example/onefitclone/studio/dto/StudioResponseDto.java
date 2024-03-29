package com.example.onefitclone.studio.dto;


import com.example.onefitclone.course.dto.CourseResponseDto;
import com.example.onefitclone.location.dto.LocationResponseDto;
import com.example.onefitclone.rating.dto.RatingResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioResponseDto extends StudioDto{
    private UUID id;
    private LocationResponseDto location;
    private List<CourseResponseDto> courses;
    private List<RatingResponseDto> ratings;
}
