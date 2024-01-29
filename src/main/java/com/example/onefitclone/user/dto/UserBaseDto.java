package com.example.onefitclone.user.dto;
import com.example.onefitclone.user.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private Double price;
    private LocalDateTime birthDate;
    private Gender gender;
}
