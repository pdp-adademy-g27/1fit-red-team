package com.example.onefitclone.history.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class History {
    @Id
    private UUID id;
    private LocalDateTime whenComing;
    private LocalDateTime whenLeft;

}
