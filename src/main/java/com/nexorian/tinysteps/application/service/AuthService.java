package com.nexorian.tinysteps.application.service;

import java.util.Map;

import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.UserEntity;

public interface AuthService {
    public ServiceResponse<Map<String, Object>> login(String phone);
    public ServiceResponse<Map<String, Object>> register(UserEntity user);
    public ServiceResponse<UserEntity> validateToken(String token);
}
