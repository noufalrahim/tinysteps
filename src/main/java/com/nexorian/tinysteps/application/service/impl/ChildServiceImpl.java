package com.nexorian.tinysteps.application.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.ChildService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.domain.repository.ChildRepository;
import com.nexorian.tinysteps.domain.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChildServiceImpl extends BaseServiceImpl<ChildEntity, UUID> implements ChildService {

    @Autowired
    private UserRepository userRepository;

    public ChildServiceImpl(ChildRepository childRepository, JpaSpecificationExecutor<ChildEntity> specRepository){
        super(childRepository, specRepository, ChildEntity.class);
    }

    @Override
    public ServiceResponse<ChildEntity> createChild(ChildEntity entity) {
        try {
            Optional<UserEntity> user = userRepository.findById(entity.getUser().getId());
            log.info("User: {}", user);
            if (user.isEmpty()) {
                return ServiceResponse.buildErrorResponse("User not found");
            }
            log.info("User: {} {}", user.get(), user.get().getDefaultChild());
            if(user.get().getDefaultChild() == null){
                user.get().setDefaultChild(entity);
                userRepository.save(user.get());
            }
            entity.setUser(user.get());
            return create(entity);
        } catch (Exception e) {
            return ServiceResponse.buildErrorResponse(e.getMessage());
        }
    }
}