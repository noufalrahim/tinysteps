package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.MedicineDTO;
import com.nexorian.tinysteps.application.service.MedicineService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.MedicineEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.MedicineMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/medicines")
public class MedicineController extends BaseController<MedicineEntity, MedicineDTO, UUID> {
    private final MedicineService medicineService;

    public MedicineController(MedicineService service) {
        super(service, MedicineMapper::toDTO);
        this.medicineService = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<ServiceResponse<MedicineDTO>> create(
            @RequestBody MedicineEntity entity) {
        try {
            ServiceResponse<MedicineEntity> resp = medicineService.create(entity);

            if (resp.getStatus() != ServiceResponse.ResStatus.SUCCESS) {
                return ResponseEntity
                        .status(resp.getStatusCode())
                        .body((ServiceResponse) resp);
            }

            MedicineDTO dto = MedicineMapper.toDTO(resp.getData());
            return ResponseEntity.status(201).body(ServiceResponse.buildResponse(dto));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}