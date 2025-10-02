package com.nexorian.tinysteps.application.service.impl;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.AgeGroupService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;
import com.nexorian.tinysteps.domain.repository.AgeGroupRepository;

@Service
public class AgeGroupServiceImpl extends BaseServiceImpl<AgeGroupEntity, UUID> implements AgeGroupService {
    public AgeGroupServiceImpl(AgeGroupRepository ageGroupRepository, JpaSpecificationExecutor<AgeGroupEntity> specRepository){
        super(ageGroupRepository, specRepository, AgeGroupEntity.class);
    }
}
