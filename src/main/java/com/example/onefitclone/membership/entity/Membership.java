package com.example.onefitclone.membership.entity;

import com.example.onefitclone.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Membership {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    private short freezeDays;
    private LocalDate bought_day;
    @Column(nullable = false)
    private int duration_days;
    @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<User> users;
}
