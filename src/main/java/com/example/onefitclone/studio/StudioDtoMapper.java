package com.example.onefitclone.studio;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.location.LocationDtoMapper;
import com.example.onefitclone.location.dto.LocationResponseDto;
import com.example.onefitclone.location.entity.Location;
import com.example.onefitclone.studio.dto.StudioCreateDto;
import com.example.onefitclone.studio.dto.StudioResponseDto;
import com.example.onefitclone.studio.dto.StudioUpdateDto;
import com.example.onefitclone.studio.entity.Studio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class StudioDtoMapper extends GenericMapper<Studio, StudioCreateDto, StudioResponseDto, StudioUpdateDto> {
    private final ModelMapper mapper;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public Studio toEntity(StudioCreateDto studioCreateDto) {
        return mapper.map(studioCreateDto, Studio.class);
    }

    @Override
    public StudioResponseDto toResponseDto(Studio studio) {
        StudioResponseDto studioResponseDto = mapper.map(studio, StudioResponseDto.class);
        Location location = studio.getLocation();
        LocationResponseDto locationResponseDto = locationDtoMapper.toResponseDto(location);
        studioResponseDto.setLocation(locationResponseDto);

        return studioResponseDto;
    }

    @Override
    public void toEntity(StudioUpdateDto studioUpdateDto, Studio studio) {
        mapper.map(studioUpdateDto, studio);
    }
}
