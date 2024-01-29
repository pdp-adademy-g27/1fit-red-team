package com.example.onefitclone.studio.entity;

import com.example.onefitclone.comment.entity.Comment;
import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.location.entity.Location;
import com.example.onefitclone.studio.category.entity.Category;
import jakarta.persistence.*;
import liquibase.integration.spring.SpringResourceAccessor;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Studio {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean isWomen;
    @ManyToMany
    @JoinTable(
            name = "studio_category",
            joinColumns = @JoinColumn(name = "studio_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Category> categories;

}
