package com.example.onefitclone.liked;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.liked.dto.LikedCreateDto;
import com.example.onefitclone.liked.dto.LikedResponseDto;
import com.example.onefitclone.liked.dto.LikedUpdateDto;
import com.example.onefitclone.liked.entity.Liked;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class LikedDtoMapper extends GenericMapper<Liked,LikedCreateDto, LikedResponseDto, LikedUpdateDto> {
    private final ModelMapper modelMapper;

    @Override
    public Liked toEntity(LikedCreateDto likedCreateDto) {
        return modelMapper.map(likedCreateDto, Liked.class);
    }

    @Override
    public LikedResponseDto toResponseDto(Liked liked) {
        return modelMapper.map(liked, LikedResponseDto.class);
    }

    @Override
    public void toEntity(LikedUpdateDto likedUpdateDto, Liked liked) {
      modelMapper.map(likedUpdateDto,liked);
    }
}
