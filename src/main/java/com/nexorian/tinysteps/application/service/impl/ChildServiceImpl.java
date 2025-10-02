package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.ChildService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.domain.repository.ChildRepository;

@Service
public class ChildServiceImpl extends BaseServiceImpl<ChildEntity, UUID> implements ChildService {
    public ChildServiceImpl(ChildRepository childRepository, JpaSpecificationExecutor<ChildEntity> specRepository){
        super(childRepository, specRepository, ChildEntity.class);
    }
}