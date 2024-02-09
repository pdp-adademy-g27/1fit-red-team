package com.example.onefitclone.history;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.history.dto.HistoryCreateDto;
import com.example.onefitclone.history.dto.HistoryResponseDto;
import com.example.onefitclone.history.dto.HistoryUpdateDto;
import com.example.onefitclone.history.entity.History;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoryDtoMapper extends GenericMapper<History, HistoryCreateDto, HistoryResponseDto, HistoryUpdateDto> {
    private final ModelMapper modelMapper;
    @Override

    public History toEntity(HistoryCreateDto historyCreateDto) {
        return modelMapper.map(historyCreateDto,History.class);
    }

    @Override
    public HistoryResponseDto toResponseDto(History history) {
        return modelMapper.map(history,HistoryResponseDto.class);
    }

    @Override
    public void toEntity(HistoryUpdateDto historyUpdateDto, History history) {
      modelMapper.map(historyUpdateDto,history);
    }
}
