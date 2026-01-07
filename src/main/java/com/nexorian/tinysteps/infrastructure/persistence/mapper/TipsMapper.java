package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.AgeGroupDTO;
import com.nexorian.tinysteps.application.dto.TipsDTO;
import com.nexorian.tinysteps.domain.entity.TipsEntity;

public class TipsMapper {
    public static TipsDTO toDTO(TipsEntity tips) {
        if (tips == null) return null;

        AgeGroupDTO ageGroupDTO = tips.getAgeGroup() != null
            ? AgeGroupMapper.toDTO(tips.getAgeGroup())
            : null;


        return new TipsDTO(
            tips.getId(),
            tips.getTitle(),
            tips.getDescription(),
            tips.getImage(),
            tips.getLink(),
            ageGroupDTO
        );
    }
}