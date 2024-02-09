package com.example.onefitclone.membership.entity;

import com.example.onefitclone.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @ManyToOne
    private User user;
}
