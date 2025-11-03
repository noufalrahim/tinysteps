package com.nexorian.tinysteps.application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.AuthService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.domain.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ServiceResponse<UserEntity> login(String phone) {
        ServiceResponse<UserEntity> response = new ServiceResponse<>();

        try {
            Optional<UserEntity> optionalUser = userRepository.findByPhone(phone);
            if (optionalUser.isPresent()) {
                UserEntity user = optionalUser.get();
                if (user.getPhone().equals(phone)) {
                    response.setData(user);
                    response.setMessage("Login successful");
                } else {
                    response.setStatus(ServiceResponse.ResStatus.ERROR);
                    response.setMessage("Invalid credentials");
                    response.setStatusCode(401);
                }
            } else {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("User not found");
                response.setStatusCode(404);
            }
        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("An error occurred during login");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(500);
        }

        return response;
    }

    @Override
    public ServiceResponse<UserEntity> register(UserEntity user) {
        ServiceResponse<UserEntity> response = new ServiceResponse<>();

        try {
            if (userRepository.findByPhone(user.getPhone()).isPresent()) {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("Phone number already registered");
                response.setStatusCode(409);
                return response;
            }

            UserEntity savedUser = userRepository.save(user);
            response.setData(savedUser);
            response.setMessage("User registered successfully");
        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Registration failed");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(500);
        }

        return response;
    }
}
