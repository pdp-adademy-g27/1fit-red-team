package com.example.onefitclone.studio.entity;

import com.example.onefitclone.course.entity.Course;
import com.example.onefitclone.location.entity.Location;
import com.example.onefitclone.rating.entity.Rating;
import com.example.onefitclone.studio.category.entity.Category;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.*;
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
    private boolean forFemale;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "studio_category",
            joinColumns = @JoinColumn(name = "studio_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Category> categories;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "studio", cascade = CascadeType.ALL)
    private Location location;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL)
    private Set<Course> courses;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL)
    private Set<Rating> ratings;

    @ManyToMany(mappedBy = "studios")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<User> users;
}
