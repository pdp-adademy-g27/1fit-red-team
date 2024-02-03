package com.example.onefitclone.location.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {
    @Id
    private UUID id;
    private String name;
    private float longitude;
    private float latitude;
}
