package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.dto.UserDTO;
import com.nexorian.tinysteps.domain.entity.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity user) {
        if (user == null) return null;

        ChildDTO defaultChildDTO = user.getDefaultChild() != null
            ? ChildMapper.toDTO(user.getDefaultChild())
            : null;

        return new UserDTO(
            user.getId(),
            defaultChildDTO,
            user.getPhone()
        );
    }
}
