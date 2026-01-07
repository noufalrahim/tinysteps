package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.TipsService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.TipsEntity;
import com.nexorian.tinysteps.domain.repository.TipsRepository;

@Service
public class TipsServiceImpl
        extends BaseServiceImpl<TipsEntity, UUID>
        implements TipsService {

    public TipsServiceImpl(TipsRepository tipsRepository, JpaSpecificationExecutor<TipsEntity> specRepository) {
        super(tipsRepository, specRepository, TipsEntity.class);
    }
}