package com.example.onefitclone.user;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.user.dto.UserCreateDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import com.example.onefitclone.user.dto.UserUpdateDto;
import com.example.onefitclone.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericMapper<User, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final ModelMapper mapper;
    @Override
    public User toEntity(UserCreateDto userCreatedDto) {

        return mapper.map(userCreatedDto,User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {

        return mapper.map(user,UserResponseDto.class);
    }

    @Override
    public void toEntity(UserUpdateDto userUpdateDto, User user) {
        mapper.map(userUpdateDto,user);

    }
}
