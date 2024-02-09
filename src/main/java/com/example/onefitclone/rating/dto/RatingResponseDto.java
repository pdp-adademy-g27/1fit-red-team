package com.example.onefitclone.rating.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class RatingResponseDto extends RatingDto{
    private UUID id;
    private String user;
    private String studio;
}
