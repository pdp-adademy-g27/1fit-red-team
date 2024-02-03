package com.example.onefitclone.rating.entity;

import com.example.onefitclone.studio.entity.Studio;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rating {
    @Id
    private UUID id;
    @Enumerated
    private RatingName ratingName;
    private byte star;
    private String comment;
    @ManyToOne
    private User user;
    @ManyToOne
    private Studio studio;
}
