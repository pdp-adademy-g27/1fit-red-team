package com.example.onefitclone.studio;

import com.example.onefitclone.common.mapper.GenericMapper;
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

    @Override
    public Studio toEntity(StudioCreateDto studioCreateDto) {
        return mapper.map(studioCreateDto, Studio.class);
    }

    @Override
    public StudioResponseDto toResponseDto(Studio studio) {
        return mapper.map(studio, StudioResponseDto.class);
    }

    @Override
    public void toEntity(StudioUpdateDto studioUpdateDto, Studio studio) {
        mapper.map(studioUpdateDto, studio);
    }
}
