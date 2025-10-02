package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.ChildResponseService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.ChildResponseEntity;
import com.nexorian.tinysteps.domain.repository.ChildResponseRepository;

@Service
public class ChildResponseServiceImpl extends BaseServiceImpl<ChildResponseEntity, UUID> implements ChildResponseService {
    public ChildResponseServiceImpl(ChildResponseRepository childResponseRepository, JpaSpecificationExecutor<ChildResponseEntity> specRepository){
        super(childResponseRepository, specRepository, ChildResponseEntity.class);
    }
}