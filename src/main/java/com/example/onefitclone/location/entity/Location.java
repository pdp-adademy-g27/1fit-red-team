package com.example.onefitclone.location.entity;

import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {
    @Id
    private UUID id;
    @NotBlank
    private String name;
    private double longitude;
    private double latitude;
    @OneToOne
    @JoinColumn(name = "studio_id",unique = true, nullable = false)
    private Studio studio;
}
