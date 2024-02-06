package com.example.onefitclone.location;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.location.dto.LocationCreateDto;
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
public class LocationService extends GenericService<Location, UUID, LocationCreateDto,LocationResponseDto, LocationCreateDto> {
    private final LocationRepository repository;
    private final Class<Location> entityClass = Location.class;
    private final LocationDtoMapper mapper;


    @Override
    protected LocationResponseDto internalCreate(LocationCreateDto locationDto) {
        Location location = mapper.toEntity(locationDto);
        location.setId(UUID.randomUUID());
        Location saved = repository.save(location);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected LocationResponseDto internalUpdate(UUID uuid, LocationCreateDto locationCreateDto) {
        Location location = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Location not found"));
        mapper.toEntity(locationCreateDto, location);
        Location saved = repository.save(location);
        return mapper.toResponseDto(saved);
    }
}
