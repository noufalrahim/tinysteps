package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nexorian.tinysteps.application.dto.TipsDTO;
import com.nexorian.tinysteps.application.service.TipsService;
import com.nexorian.tinysteps.domain.entity.TipsEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.TipsMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/tips")

public class TipsController extends BaseController<TipsEntity, TipsDTO, UUID> {
    public TipsController(TipsService service) {
        super(service, TipsMapper::toDTO);
    }
}