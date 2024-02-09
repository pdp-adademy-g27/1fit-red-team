package com.example.onefitclone.history;
import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.history.dto.HistoryCreateDto;
import com.example.onefitclone.history.dto.HistoryResponseDto;
import com.example.onefitclone.history.dto.HistoryUpdateDto;
import com.example.onefitclone.history.entity.History;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class HistoryService extends GenericService<History, UUID, HistoryCreateDto, HistoryResponseDto, HistoryUpdateDto> {
    private final HistoryRepository repository;
    private final Class<History> entityClass = History.class;
    private final HistoryDtoMapper mapper;

    @Override
    protected HistoryResponseDto internalCreate(HistoryCreateDto historyCreateDto) {
        History history = mapper.toEntity(historyCreateDto);
        history.setId(UUID.randomUUID());
        History saved = repository.save(history);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected HistoryResponseDto internalUpdate(UUID uuid, HistoryUpdateDto historyUpdateDto) {
        History history=repository.findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException(" History not found")
                );
        mapper.toEntity(historyUpdateDto,history);
        History saved = repository.save(history);
        return mapper.toResponseDto(saved);
    }
}
