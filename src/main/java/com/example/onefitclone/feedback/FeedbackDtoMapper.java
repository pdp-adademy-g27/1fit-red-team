package com.example.onefitclone.feedback;
import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.feedback.dto.FeedbackCreateDto;
import com.example.onefitclone.feedback.dto.FeedbackResponseDto;
import com.example.onefitclone.feedback.dto.FeedbackUpdateDto;
import com.example.onefitclone.feedback.entity.Feedback;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedbackDtoMapper extends GenericMapper<Feedback, FeedbackCreateDto, FeedbackResponseDto, FeedbackUpdateDto> {
    private final ModelMapper modelMapper;
    @Override
    public Feedback toEntity(FeedbackCreateDto feedbackCreateDto) {
       return modelMapper.map(feedbackCreateDto,Feedback.class);
    }

    @Override
    public FeedbackResponseDto toResponseDto(Feedback feedback) {
        return modelMapper.map(feedback,FeedbackResponseDto.class);
    }

    @Override
    public void toEntity(FeedbackUpdateDto feedbackUpdateDto, Feedback feedback) {
        modelMapper.map(feedbackUpdateDto,feedback);

   }

}
