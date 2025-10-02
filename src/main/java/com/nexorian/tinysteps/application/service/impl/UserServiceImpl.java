package com.nexorian.tinysteps.application.service.impl;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.UserService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.domain.repository.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UUID> implements UserService {
    public UserServiceImpl(UserRepository userRepository, JpaSpecificationExecutor<UserEntity> specRepository){
        super(userRepository, specRepository, UserEntity.class);
    }
}