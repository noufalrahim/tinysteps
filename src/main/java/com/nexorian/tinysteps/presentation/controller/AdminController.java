package com.nexorian.tinysteps.presentation.controller;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.AdminDTO;
import com.nexorian.tinysteps.application.service.AdminService;
import com.nexorian.tinysteps.domain.entity.AdminEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.AdminMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;


@RestController
@RequestMapping("/columns")
public class AdminController extends BaseController<AdminEntity, AdminDTO, UUID> {
    public AdminController(AdminService service){
        super(service, AdminMapper::toDTO);
    }
};
