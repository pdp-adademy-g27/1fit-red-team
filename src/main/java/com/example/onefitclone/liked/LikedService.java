package com.example.onefitclone.liked;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.liked.dto.LikedCreateDto;
import com.example.onefitclone.liked.dto.LikedResponseDto;
import com.example.onefitclone.liked.dto.LikedUpdateDto;
import com.example.onefitclone.liked.entity.Liked;
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
        return null;
    }

    @Override
    protected LikedResponseDto internalUpdate(UUID uuid, LikedUpdateDto likedUpdateDto) {
        return null;
    }
}
