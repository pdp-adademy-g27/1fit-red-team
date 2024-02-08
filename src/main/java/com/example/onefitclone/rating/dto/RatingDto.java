package com.example.onefitclone.rating.dto;

import com.example.onefitclone.rating.entity.RatingName;
import com.example.onefitclone.studio.entity.Studio;
import com.example.onefitclone.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private RatingName ratingName;
    private int star;
    private String comment;
    private User user;
    private Studio studio;
}
