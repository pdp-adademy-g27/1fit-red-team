package com.example.onefitclone.location;

import com.example.onefitclone.location.dto.LocationDto;
import com.example.onefitclone.location.dto.LocationResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController
{
    private final LocationService service;

    @PostMapping
    public ResponseEntity<LocationResponseDto> create(@RequestBody @Valid LocationDto locationDto){
        LocationResponseDto locationResponseDto = service.create(locationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationResponseDto);
    }

}
