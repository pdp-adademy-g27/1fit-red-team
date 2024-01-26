package com.example.onefitclone.gym.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Gym {
    @Id
    private UUID id;
    private String name;
    private String comment;
    private Boolean isWomens;


}
