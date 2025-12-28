package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.PostDTO;
import com.nexorian.tinysteps.application.service.PostService;
import com.nexorian.tinysteps.domain.entity.PostEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.PostMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/posts")
public class PostController extends BaseController<PostEntity, PostDTO, UUID> {

    public PostController(PostService service) {
        super(service, PostMapper::toDTO);
    }
}
