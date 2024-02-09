package com.example.onefitclone.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MembershipDto {
    private String name;
    private short freezeDays;
    private LocalDate duration_day;
}