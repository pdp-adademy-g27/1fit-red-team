package com.example.onefitclone.location;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.location.dto.LocationDto;
import com.example.onefitclone.location.dto.LocationResponseDto;
import com.example.onefitclone.location.entity.Location;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class LocationService extends GenericService<Location, UUID, LocationDto, LocationResponseDto, LocationDto> {
    private final LocationRepository repository;
    private final Class<Location> entityClass = Location.class;
    private final LocationDtoMapper mapper;


    @Override
    protected LocationResponseDto internalCreate(LocationDto locationDto) {
        Location location = mapper.toEntity(locationDto);
        location.setId(UUID.randomUUID());
        Location saved = repository.save(location);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected LocationResponseDto internalUpdate(UUID uuid, LocationDto locationDto) {
        Location location = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Location not found"));
        mapper.toEntity(locationDto, location);
        Location saved = repository.save(location);
        return mapper.toResponseDto(saved);
    }
}
