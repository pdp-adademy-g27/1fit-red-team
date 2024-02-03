package com.example.onefitclone.user;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.user.dto.UserCreateDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import com.example.onefitclone.user.dto.UserUpdateDto;
import com.example.onefitclone.user.entity.User;
import com.example.onefitclone.user.permission.entity.Permission;
import com.example.onefitclone.user.role.RoleDtoMapper;
import com.example.onefitclone.user.role.dto.RoleResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericMapper<User, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final ModelMapper mapper;
    private final RoleDtoMapper roleDtoMapper;
    @Override
    public User toEntity(UserCreateDto userCreatedDto) {

        return mapper.map(userCreatedDto,User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {

        UserResponseDto responseDto = mapper.map(user, UserResponseDto.class);

        Set<RoleResponseDto> roles = user
                .getRoles()
                .stream()
                .map(roleDtoMapper::toResponseDto)
                .collect(Collectors.toSet());

        if (user.getPermissions()!=null) {
            Set<String> permissions = user
                    .getPermissions()
                    .stream()
                    .map(Permission::getName)
                    .collect(Collectors.toSet());

            responseDto.setPermissions(permissions);
        }
        responseDto.setRoles(roles);
        return responseDto;
    }

    @Override
    public void toEntity(UserUpdateDto userUpdateDto, User user) {
        mapper.map(userUpdateDto,user);

    }
}
