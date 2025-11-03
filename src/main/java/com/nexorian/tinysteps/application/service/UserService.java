package com.nexorian.tinysteps.application.service;

import java.util.UUID;

import com.nexorian.tinysteps.application.service.base.BaseService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.domain.entity.UserEntity;


public interface UserService extends BaseService<UserEntity, UUID> {
    public ServiceResponse<UserEntity> updateDefaultChild(ChildEntity child);
}
