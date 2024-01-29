package com.example.onefitclone.user;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.user.dto.UserCreatedDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import com.example.onefitclone.user.dto.UserUpdateDto;
import com.example.onefitclone.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserDtoMapper extends GenericMapper<User, UserCreatedDto, UserResponseDto, UserUpdateDto> {

    @Override
    public User toEntity(UserCreatedDto userCreatedDto) {
        return null;
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        return null;
    }

    @Override
    public void toEntity(UserUpdateDto userUpdateDto, User user) {

    }
}
