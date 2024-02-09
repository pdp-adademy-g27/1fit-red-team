package com.example.onefitclone.liked;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.liked.dto.LikedCreateDto;
import com.example.onefitclone.liked.dto.LikedResponseDto;
import com.example.onefitclone.liked.dto.LikedUpdateDto;
import com.example.onefitclone.liked.entity.Liked;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class LikedService extends GenericService<Liked, UUID, LikedCreateDto, LikedResponseDto, LikedUpdateDto> {
    private final LikedRepository repository;
    private final Class<Liked> entityClass = Liked.class;
    private final LikedDtoMapper mapper;

    @Override
    protected LikedResponseDto internalCreate(LikedCreateDto likedCreateDto) {

        Liked liked = mapper.toEntity(likedCreateDto);
        liked.setId(UUID.randomUUID());
        Liked saved = repository.save(liked);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected LikedResponseDto internalUpdate(UUID uuid, LikedUpdateDto likedUpdateDto) {

        Liked liked = repository.findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException(" Liked not found")
                );
        mapper.toEntity(likedUpdateDto, liked);
        Liked saved = repository.save(liked);
        return mapper.toResponseDto(saved);
    }
}
