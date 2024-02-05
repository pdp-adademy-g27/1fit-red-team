package com.example.onefitclone.liked.entity;

import com.example.onefitclone.course.entity.Course;
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
public class Liked {
    @Id
    private UUID id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
}
