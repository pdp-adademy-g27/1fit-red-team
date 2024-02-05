package com.example.onefitclone.studio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudioDto {
    private String name;
    private String description;
    private boolean forFemale;
}
