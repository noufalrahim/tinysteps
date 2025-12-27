package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.AgeGroupService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;
import com.nexorian.tinysteps.domain.repository.AgeGroupRepository;

@Service
public class AgeGroupServiceImpl
        extends BaseServiceImpl<AgeGroupEntity, UUID>
        implements AgeGroupService {

    private final AgeGroupRepository ageGroupRepository;

    public AgeGroupServiceImpl(AgeGroupRepository ageGroupRepository) {
        super(ageGroupRepository, ageGroupRepository, AgeGroupEntity.class);
        this.ageGroupRepository = ageGroupRepository;
    }

    @Override
    public ServiceResponse<AgeGroupEntity> create(AgeGroupEntity entity) {

        ServiceResponse<AgeGroupEntity> response = new ServiceResponse<>();

        if (entity.getStartAge() > entity.getEndAge()) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Start age cannot be greater than end age");
            response.setStatusCode(400);
            return response;
        }

        boolean overlaps = ageGroupRepository.existsOverlappingRange(
                entity.getStartAge(),
                entity.getEndAge()
        );

        if (overlaps) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Age group overlaps with an existing range");
            response.setStatusCode(400);
            return response;
        }

        try {
            return super.create(entity);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Failed to create age group");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(500);
            return response;
        }
    }
}
