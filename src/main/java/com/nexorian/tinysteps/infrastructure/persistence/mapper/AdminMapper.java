package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.AdminDTO;
import com.nexorian.tinysteps.domain.entity.AdminEntity;

public class AdminMapper {

    public static AdminDTO toDTO(AdminEntity admin) {
        if (admin == null) return null;

        return new AdminDTO(
            admin.getId(),
            admin.getName(),
            admin.isSuperAdmin(),
            admin.isHasEditAccess(),
            admin.isHasDeleteAccess()
        );
    }
}
