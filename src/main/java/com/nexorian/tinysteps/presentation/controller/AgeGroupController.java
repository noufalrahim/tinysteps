package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.AgeGroupDTO;
import com.nexorian.tinysteps.application.service.AgeGroupService;
import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.AgeGroupMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/age-groups")
public class AgeGroupController extends BaseController<AgeGroupEntity, AgeGroupDTO, UUID> {

    public AgeGroupController(AgeGroupService service) {
        super(service, AgeGroupMapper::toDTO);
    }
}
