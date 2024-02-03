package com.example.onefitclone.feedback;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.feedback.dto.FeedbackCreateDto;
import com.example.onefitclone.feedback.dto.FeedbackResponseDto;
import com.example.onefitclone.feedback.dto.FeedbackUpdateDto;
import com.example.onefitclone.feedback.entity.Feedback;
import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class FeedbackService extends GenericService<Feedback, UUID, FeedbackCreateDto, FeedbackResponseDto, FeedbackUpdateDto> {
    private final FeedbackRepository repository;
    private final Class<Feedback> entityClass = Feedback.class;
    private final FeedbackDtoMapper mapper;

    @Override
    protected FeedbackResponseDto internalCreate(FeedbackCreateDto feedbackCreateDto) {
        Feedback feedback = mapper.toEntity(feedbackCreateDto);
        feedback.setId(UUID.randomUUID());
        Feedback saved = repository.save(feedback);
        return mapper.toResponseDto(saved);


    }

    @Override
    protected FeedbackResponseDto internalUpdate(UUID uuid, FeedbackUpdateDto feedbackUpdateDto) {
        Feedback feedback=repository.findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException(" Feedback not found")
                );
        mapper.toEntity(feedbackUpdateDto,feedback);
        Feedback saved = repository.save(feedback);
        return mapper.toResponseDto(saved);
    }

}
