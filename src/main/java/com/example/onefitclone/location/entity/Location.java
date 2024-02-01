package com.example.onefitclone.location.entity;

import lombok.*;

=======
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Location {
    @Id
    private UUID id;
}
