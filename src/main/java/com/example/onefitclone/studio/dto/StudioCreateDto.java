package com.example.onefitclone.studio.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioCreateDto extends StudioDto {
    @NotEmpty(message = "Categories not be empty")
    private Set<String> categories;
    private String location;
}
