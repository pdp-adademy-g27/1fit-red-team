package com.example.onefitclone.user.dto;

import com.example.onefitclone.membership.entity.Membership;
import com.example.onefitclone.user.role.dto.RoleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto extends UserBaseDto{
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Set<RoleResponseDto> roles;
    private Set<String> permissions;
    private Set<Membership> memberships;

}
