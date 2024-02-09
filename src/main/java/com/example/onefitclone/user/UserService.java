package com.example.onefitclone.user;

import com.example.onefitclone.common.exceptions.OtpException;
import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.membership.MembershipRepository;
import com.example.onefitclone.membership.entity.Membership;
import com.example.onefitclone.user.dto.UserCreateDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import com.example.onefitclone.user.dto.UserSignInDto;
import com.example.onefitclone.user.dto.UserUpdateDto;
import com.example.onefitclone.user.entity.User;
import com.example.onefitclone.user.otp.OtpRepository;
import com.example.onefitclone.user.otp.entity.Otp;
import com.example.onefitclone.user.role.RoleRepository;
import com.example.onefitclone.user.role.entity.Role;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
@RequiredArgsConstructor
public class UserService  extends GenericService<User, UUID, UserCreateDto, UserResponseDto, UserUpdateDto> {
    private final UserRepository repository;
    private final Class<User> entityClass=User.class;
    private final UserDtoMapper mapper;
    private final OtpRepository otpRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final MembershipRepository membershipRepository;

    @Override
    protected UserResponseDto internalCreate(UserCreateDto userCreatedDto) {
        User user = mapper.toEntity(userCreatedDto);
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(100000.0);


        Set<Role> roles = Collections.singleton(roleRepository.findByName("USER").orElseThrow());
        user.setRoles(roles);

        isPhoneNumberVerified(userCreatedDto.getPhoneNumber());

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

    private void isPhoneNumberVerified(String phoneNumber) {
        Otp otp = otpRepository
                .findById(phoneNumber)
                .orElseThrow(() -> new OtpException.PhoneNumberNotVerified(phoneNumber));

        if (!otp.isVerified()) {
            throw new OtpException.PhoneNumberNotVerified(phoneNumber);
        }
    }

    @Transactional
    public UserResponseDto signIn(UserSignInDto signInDto) {
        User user = repository.findByPhoneNumber(signInDto.getPhoneNumber())
                .orElseThrow(() -> new BadCredentialsException("Username or password is not correct"));

        if (!passwordEncoder.matches(signInDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Username or password is not correct");
        }

        return mapper.toResponseDto(user);
    }

    @Transactional
    public UserResponseDto addMembership(UUID userId, UUID membershipId) {
        User user = repository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found by id: " + userId));
        Membership membership = membershipRepository.findById(membershipId).orElseThrow(() -> new EntityNotFoundException("Membership not found by id: " + membershipId));
        user.setMembership(membership);
        User saved = repository.save(user);
        membershipRepository.save(membership);
        return mapper.toResponseDto(saved);
    }


}
