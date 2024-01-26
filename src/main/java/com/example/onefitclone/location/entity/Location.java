package com.example.onefitclone.location.entity;

import com.example.onefitclone.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "`location`")
public class Location {
    @Id
    private UUID id;
    private String upAddress;
    private String deviceName;
    private String fullLocation;
    private String longitude;
    private String latitude;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime updated;
    @ManyToMany(mappedBy = "location")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<User> users;

}
