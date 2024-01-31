package com.example.onefitclone.user;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.user.dto.UserCreateDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import com.example.onefitclone.user.dto.UserUpdateDto;
import com.example.onefitclone.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class UserService  extends GenericService<User, UUID, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final UserRepository repository;
    private final Class<User> entityClass=User.class;
    private final UserDtoMapper mapper;

    @Override
    protected UserResponseDto internalCreate(UserCreateDto userCreatedDto) {
        User user = mapper.toEntity(userCreatedDto);
        user.setId(UUID.randomUUID());
        User saved = repository.save(user);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected UserResponseDto internalUpdate(UUID uuid, UserUpdateDto userUpdateDto) {
       User user=repository.findById(uuid).orElseThrow(
               ()-> new EntityNotFoundException("User not found")
       );
       mapper.toEntity(userUpdateDto,user);
        User saved = repository.save(user);
        return mapper.toResponseDto(saved);

    }


}
