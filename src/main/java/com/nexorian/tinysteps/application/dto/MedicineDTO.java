package com.nexorian.tinysteps.application.dto;

import java.util.Set;
import java.util.UUID;

import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {
    private UUID id;
    private String name;
    private String description;
    private String type;
    private Set<AgeGroupEntity> ageGroups;
}