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
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;
}
