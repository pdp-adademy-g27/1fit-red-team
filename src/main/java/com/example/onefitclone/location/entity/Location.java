package com.example.onefitclone.location.entity;

import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(getLongitude(), location.getLongitude()) == 0 && Double.compare(getLatitude(), location.getLatitude()) == 0 && Objects.equals(getId(), location.getId()) && Objects.equals(getName(), location.getName()) && Objects.equals(getStudio(), location.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLongitude(), getLatitude());
    }
}
