package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.TimelineDTO;
import com.nexorian.tinysteps.application.service.TimelineService;
import com.nexorian.tinysteps.domain.entity.TimelineEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.TimelineMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/timelines")
public class TimelineController extends BaseController<TimelineEntity, TimelineDTO, UUID> {

    public TimelineController(TimelineService service) {
        super(service, TimelineMapper::toDTO);
    }
}