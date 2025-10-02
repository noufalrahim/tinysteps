package com.nexorian.tinysteps.application.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.nexorian.tinysteps.domain.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChildDTO {
    private UUID id;
    private String name;
    private GenderEnum gender;
    private LocalDate dateOfBirth;
    private boolean isPremature;
    private Integer weekOfPrematurity;
    private UUID userId;
}
