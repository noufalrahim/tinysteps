package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.MedicineDTO;
import com.nexorian.tinysteps.application.service.MedicineService;
import com.nexorian.tinysteps.domain.entity.MedicineEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.MedicineMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/medicines")
public class MedicineController extends BaseController<MedicineEntity, MedicineDTO, UUID> {

    public MedicineController(MedicineService service) {
        super(service, MedicineMapper::toDTO);
    }
}