package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.ChildResponseDTO;
import com.nexorian.tinysteps.application.service.ChildResponseService;
import com.nexorian.tinysteps.domain.entity.ChildResponseEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.ChildResponseMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/child-responses")
public class ChildResponseController extends BaseController<ChildResponseEntity, ChildResponseDTO, UUID> {

    public ChildResponseController(ChildResponseService service) {
        super(service, ChildResponseMapper::toDTO);
    }
}
