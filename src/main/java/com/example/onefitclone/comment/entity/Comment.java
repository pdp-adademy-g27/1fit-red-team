package com.example.onefitclone.comment.entity;

import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.rating.entity.Rating;
import com.example.onefitclone.studio.entity.Studio;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    private UUID id;
    private String comment;
    @ManyToOne
    private Rating rating;
    @ManyToOne
    private Course course;
    @ManyToOne
    private User user;
    @ManyToOne
    private Studio studio;
}
