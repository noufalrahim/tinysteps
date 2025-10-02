package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.service.ChildService;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.ChildMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/children")
public class ChildController extends BaseController<ChildEntity, ChildDTO, UUID> {

    public ChildController(ChildService service) {
        super(service, ChildMapper::toDTO);
    }
}
