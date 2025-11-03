package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.TimelineService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.TimelineEntity;
import com.nexorian.tinysteps.domain.repository.TimelineRepository;

@Service
public class TimelineServiceImpl extends BaseServiceImpl<TimelineEntity, UUID> implements TimelineService {

    public TimelineServiceImpl(TimelineRepository timelineRepository, JpaSpecificationExecutor<TimelineEntity> specRepository) {
        super(timelineRepository, specRepository, TimelineEntity.class);
    }
}
