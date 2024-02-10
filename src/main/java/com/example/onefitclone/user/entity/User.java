package com.example.onefitclone.user.entity;

import com.example.onefitclone.history.entity.History;
import com.example.onefitclone.membership.entity.Membership;
import com.example.onefitclone.rating.entity.Rating;
import com.example.onefitclone.user.permission.entity.Permission;
import com.example.onefitclone.user.role.entity.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "`user`")
public class User  implements UserDetails {
    @Id
    private UUID id;
    private String name;
    private String surname;
    @Column(nullable = false ,unique = true)
    private String phoneNumber;
    private String password;
    @Column(nullable = false ,unique = true)
    private String email;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime updated;
    private Double balance;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "boolean default false")
    private boolean isVerify;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Membership membership;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<History> histories;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Stream<Permission> rolePermissionStream = roles.stream()
                .map(Role::getPermissions)
                .flatMap(Collection::stream);

        Stream<Permission> permissionStream = Stream.concat(rolePermissionStream, permissions.stream());

        Set<SimpleGrantedAuthority> collect = permissionStream
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toSet());

        return collect;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @OneToMany(mappedBy = "user")
    private Set<Rating> ratings;

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
