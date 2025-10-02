package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.UserDTO;
import com.nexorian.tinysteps.application.service.UserService;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.UserMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserEntity, UserDTO, UUID> {

    public UserController(UserService service) {
        super(service, UserMapper::toDTO);
    }
}
