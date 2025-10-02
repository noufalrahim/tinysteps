package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.AgeGroupDTO;
import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;

public class AgeGroupMapper {

    public static AgeGroupDTO toDTO(AgeGroupEntity ageGroup) {
        if (ageGroup == null) return null;

        return new AgeGroupDTO(
            ageGroup.getId(),
            ageGroup.getStartAge(),
            ageGroup.getEndAge()
        );
    }
}
