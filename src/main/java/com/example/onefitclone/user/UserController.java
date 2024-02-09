package com.example.onefitclone.user;

import com.example.onefitclone.common.response.CommonResponse;
import com.example.onefitclone.security.JwtService;
import com.example.onefitclone.user.dto.*;
import com.example.onefitclone.user.otp.OtpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final OtpService otpService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto createDto) {
        UserResponseDto responseDto = userService.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> get(@RequestParam(required = false) String predicate, Pageable pageable) {
        Page<UserResponseDto> all = userService.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> get(@PathVariable UUID id) {
        UserResponseDto responseDto = userService.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id, @RequestBody UserUpdateDto updateDto) {
        UserResponseDto responseDto = userService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/auth/validate")
    public ResponseEntity<CommonResponse> validatePhoneNumber(
            @RequestBody @Valid ValidatePhoneNumberRequestDto requestDto
    ) {
        CommonResponse commonResponse = otpService.sendSms(requestDto);
        return ResponseEntity.ok(commonResponse);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<UserResponseDto> signUp(
            @RequestBody @Valid UserCreateDto userCreateDto
    ) {
        UserResponseDto userResponseDto = userService.create(userCreateDto);
        String token = jwtService.generateToken(userResponseDto.getPhoneNumber());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(userResponseDto);
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<UserResponseDto> singIn(
            @RequestBody @Valid UserSignInDto signInDto
    ) {
        UserResponseDto userResponseDto = userService.signIn(signInDto);
        String token = jwtService.generateToken(userResponseDto.getPhoneNumber());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(userResponseDto);
    }

    @PostMapping("/{user_id}/add/membership/{membership_id}")
    public ResponseEntity<UserResponseDto> addMembership(@PathVariable UUID user_id, @PathVariable UUID membership_id){
        UserResponseDto userResponseDto = userService.addMembership(user_id, membership_id);
        return ResponseEntity.ok(userResponseDto);
    }
}