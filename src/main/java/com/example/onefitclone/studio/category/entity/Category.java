package com.example.onefitclone.studio.category.entity;

import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category {
    @Id
    private String name;
    @ManyToMany(mappedBy = "categories")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Studio> studios;
}
