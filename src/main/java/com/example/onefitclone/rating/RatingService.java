package com.example.onefitclone.rating;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.rating.dto.RatingCreateDto;
import com.example.onefitclone.rating.dto.RatingResponseDto;
import com.example.onefitclone.rating.dto.RatingUpdateDto;
import com.example.onefitclone.rating.entity.Rating;
import com.example.onefitclone.studio.StudioRepository;
import com.example.onefitclone.studio.entity.Studio;
import com.example.onefitclone.user.UserRepository;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class RatingService extends GenericService<Rating, UUID, RatingCreateDto, RatingResponseDto, RatingUpdateDto> {
    private final RatingRepository repository;
    private final StudioRepository studioRepository;
    private final UserRepository userRepository;
    private final Class<Rating> entityClass = Rating.class;
    private final RatingDtoMapper mapper;

    @Override
    protected RatingResponseDto internalCreate(RatingCreateDto ratingCreateDto) {
        Rating rating = mapper.toEntity(ratingCreateDto);

        UUID studioId = ratingCreateDto.getStudioId();
        UUID userId = ratingCreateDto.getUserId();

        Studio studio = studioRepository.findById(studioId).orElseThrow(() -> new EntityNotFoundException("Studio not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        rating.setUser(user);
        rating.setStudio(studio);
        rating.setId(UUID.randomUUID());
        studio.getRatings().add(rating);

        studioRepository.save(studio);
        userRepository.save(user);
        Rating saved = repository.save(rating);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected RatingResponseDto internalUpdate(UUID uuid, RatingUpdateDto ratingUpdateDto) {
        return null;
    }
}
