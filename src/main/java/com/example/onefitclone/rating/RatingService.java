package com.example.onefitclone.rating;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.rating.dto.RatingCreateDto;
import com.example.onefitclone.rating.dto.RatingResponseDto;
import com.example.onefitclone.rating.dto.RatingUpdateDto;
import com.example.onefitclone.rating.entity.Rating;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class RatingService extends GenericService<Rating, UUID, RatingCreateDto, RatingResponseDto, RatingUpdateDto> {
    private final RatingRepository repository;
    private final Class<Rating> entityClass = Rating.class;
    private final RatingDtoMapper mapper;

    @Override
    protected RatingResponseDto internalCreate(RatingCreateDto ratingCreateDto) {
        Rating rating = mapper.toEntity(ratingCreateDto);
        rating.setId(UUID.randomUUID());
        Rating saved = repository.save(rating);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected RatingResponseDto internalUpdate(UUID uuid, RatingUpdateDto ratingUpdateDto) {
        return null;
    }
}
