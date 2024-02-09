package com.example.onefitclone.comment.entity;

import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private User user;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Comment comment1)) return false;
//        return Objects.equals(getId(), comment1.getId()) && Objects.equals(getComment(), comment1.getComment()) && Objects.equals(getCourse(), comment1.getCourse()) && Objects.equals(getUser(), comment1.getUser());
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getComment(), getCourse());
//    }
}
