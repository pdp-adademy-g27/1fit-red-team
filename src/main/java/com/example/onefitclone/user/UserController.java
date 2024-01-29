package com.example.onefitclone.user;

import com.example.onefitclone.user.dto.UserCreatedDto;
import com.example.onefitclone.user.dto.UserResponseDto;
import com.example.onefitclone.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userServise;
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreatedDto createDto) {
        UserResponseDto responseDto = userServise.create(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> get(@RequestParam String predicate, Pageable pageable) {
        Page<UserResponseDto> all = userServise.getAll(predicate, pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> get(@PathVariable UUID id) {
        UserResponseDto responseDto = userServise.get(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id, @RequestBody UserUpdateDto updateDto) {
        UserResponseDto responseDto = userServise.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable UUID id) {
        userServise.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

