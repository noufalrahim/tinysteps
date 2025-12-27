package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.service.ChildService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.ChildMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/children")
public class ChildController extends BaseController<ChildEntity, ChildDTO, UUID> {

    private final ChildService childService;

    public ChildController(ChildService service) {
        super(service, ChildMapper::toDTO);
        this.childService = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<ServiceResponse<ChildDTO>> create(
            @RequestBody ChildEntity entity) {
        ServiceResponse<ChildEntity> resp = childService.createChild(entity);

        if (resp.getStatus() != ServiceResponse.ResStatus.SUCCESS) {
            return ResponseEntity
                    .status(resp.getStatusCode())
                    .body((ServiceResponse) resp);
        }

        ChildDTO dto = ChildMapper.toDTO(resp.getData());
        return ResponseEntity.status(201).body(ServiceResponse.buildResponse(dto));
    }

}
