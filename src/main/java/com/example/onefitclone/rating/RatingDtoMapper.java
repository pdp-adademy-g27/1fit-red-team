package com.example.onefitclone.rating;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.rating.dto.RatingCreateDto;
import com.example.onefitclone.rating.dto.RatingResponseDto;
import com.example.onefitclone.rating.dto.RatingUpdateDto;
import com.example.onefitclone.rating.entity.Rating;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RatingDtoMapper extends GenericMapper<Rating, RatingCreateDto, RatingResponseDto, RatingUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Rating toEntity(RatingCreateDto ratingCreateDto) {
        return mapper.map(ratingCreateDto, Rating.class);
    }

    @Override
    public RatingResponseDto toResponseDto(Rating rating) {
        String userName = rating.getUser().getName();
        String studioName = rating.getStudio().getName();
        RatingResponseDto responseDto = mapper.map(rating, RatingResponseDto.class);
        responseDto.setUser(userName);
        responseDto.setStudio(studioName);
        return responseDto;
    }

    @Override
    public void toEntity(RatingUpdateDto ratingUpdateDto, Rating rating) {
        mapper.map(ratingUpdateDto, rating);
    }
}
