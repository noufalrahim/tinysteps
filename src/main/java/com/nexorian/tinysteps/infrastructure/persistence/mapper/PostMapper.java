package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.dto.PostDTO;
import com.nexorian.tinysteps.application.dto.UserDTO;
import com.nexorian.tinysteps.domain.entity.PostEntity;

public class PostMapper {

    public static PostDTO toDTO(PostEntity post) {
        if (post == null) return null;

        UserDTO userDTO = post.getUser() != null
            ? UserMapper.toDTO(post.getUser())
            : null;

        ChildDTO childDTO = post.getChild() != null
            ? ChildMapper.toDTO(post.getChild())
            : null;

        return new PostDTO(
            post.getId(),
            userDTO,
            childDTO,
            post.getContent(),
            post.getImage(),
            post.getCreatedAt(),
            post.getUpdatedAt()
        );
    }
}
