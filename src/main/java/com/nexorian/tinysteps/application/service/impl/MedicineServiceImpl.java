package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import com.nexorian.tinysteps.application.service.MedicineService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.MedicineEntity;
import com.nexorian.tinysteps.domain.repository.MedicineRepository;

@Service
public class MedicineServiceImpl extends BaseServiceImpl<MedicineEntity, UUID> implements MedicineService {
    public MedicineServiceImpl(MedicineRepository medicineRepository, JpaSpecificationExecutor<MedicineEntity> specRepository){
        super(medicineRepository, specRepository, MedicineEntity.class);
    }
}