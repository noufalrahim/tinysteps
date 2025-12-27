package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.CategoryDTO;
import com.nexorian.tinysteps.domain.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryDTO toDTO(CategoryEntity category) {
        if (category == null) return null;

        return new CategoryDTO(
            category.getId(),
            category.getName(),
            category.getDescription(),
            category.getImage()
        );
    }
}
