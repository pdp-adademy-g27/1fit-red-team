package com.example.onefitclone.history.entity;

import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class History {
    @Id
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime whenComing;
    @Column(nullable = false)
    private LocalDateTime whenLeft;

    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;

}
