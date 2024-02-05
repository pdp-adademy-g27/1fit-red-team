package com.example.onefitclone.location;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.location.dto.LocationCreateDto;
import com.example.onefitclone.location.dto.LocationResponseDto;
import com.example.onefitclone.location.entity.Location;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationDtoMapper extends GenericMapper<Location, LocationCreateDto, LocationResponseDto, LocationCreateDto> {
    private final ModelMapper mapper;

    @Override
    public Location toEntity(LocationCreateDto locationDto) {
        return mapper.map(locationDto, Location.class);
    }

    @Override
    public LocationResponseDto toResponseDto(Location location) {
        return mapper.map(location, LocationResponseDto.class);
    }

    @Override
    public void toEntity(LocationCreateDto locationDto, Location location) {
        mapper.map(locationDto, location);
    }
}
