package com.example.onefitclone.user.dto;

import com.example.onefitclone.user.role.dto.RoleResponseDto;
import com.example.onefitclone.user.role.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto extends UserBaseDto {
    private String password;
}
