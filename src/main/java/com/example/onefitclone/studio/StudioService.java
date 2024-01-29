package com.example.onefitclone.studio;

import com.example.onefitclone.comment.entity.Comment;
import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.studio.dto.StudioCreateDto;
import com.example.onefitclone.studio.dto.StudioResponseDto;
import com.example.onefitclone.studio.dto.StudioUpdateDto;
import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Getter
@RequiredArgsConstructor
public class StudioService extends GenericService<Studio, UUID, StudioCreateDto, StudioResponseDto, StudioUpdateDto> {
    private final StudioRepository repository;
    private final Class<Studio> entityClass = Studio.class;
    private final StudioDtoMapper mapper;

    @Override
    protected StudioResponseDto internalCreate(StudioCreateDto studioCreateDto) {
        Studio entity = mapper.toEntity(studioCreateDto);
        entity.setId(UUID.randomUUID());
        Studio saved = repository.save(entity);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected StudioResponseDto internalUpdate(UUID uuid, StudioUpdateDto studioUpdateDto) {
        Studio studio = repository
                .findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException("Studio not found")
                );
        studio.setName(studioUpdateDto.getName());
        studio.setDescription(studioUpdateDto.getDescription());
        studio.setWomen(studioUpdateDto.isWomen());
        Studio saved = repository.save(studio);
        return mapper.toResponseDto(saved);
    }
}
