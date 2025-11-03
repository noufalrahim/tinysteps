package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.domain.entity.ChildEntity;

public class ChildMapper {

    public static ChildDTO toDTO(ChildEntity child) {
        if (child == null) return null;

        return new ChildDTO(
            child.getId(),
            child.getName(),
            child.getGender(),
            child.getDateOfBirth(),
            child.isPremature(),
            child.getWeekOfPrematurity(),
            child.getUser() != null ? child.getUser().getId() : null
        );
    }

    public static ChildEntity toEntity(ChildDTO dto) {
        if (dto == null) return null;

        ChildEntity entity = new ChildEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setPremature(dto.isPremature());
        entity.setWeekOfPrematurity(dto.getWeekOfPrematurity());
        // user will be set in controller
        return entity;
    }
}
