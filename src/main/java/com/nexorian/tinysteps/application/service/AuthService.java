package com.nexorian.tinysteps.application.service;

import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.UserEntity;

public interface AuthService {
    public ServiceResponse<UserEntity> login(String phone);
    public ServiceResponse<UserEntity> register(UserEntity user);
}
