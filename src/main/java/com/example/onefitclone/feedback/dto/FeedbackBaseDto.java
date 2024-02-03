package com.example.onefitclone.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackBaseDto {
    private String studioName;
    private String userName;
    private String phoneNumber;
    private String email;
}
