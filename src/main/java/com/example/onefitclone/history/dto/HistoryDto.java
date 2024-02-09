package com.example.onefitclone.history.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryDto {
    private LocalDateTime whenComing;
    private LocalDateTime whenLeft;
}
