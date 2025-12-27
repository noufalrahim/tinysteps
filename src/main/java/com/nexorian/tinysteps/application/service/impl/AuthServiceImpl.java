package com.nexorian.tinysteps.application.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.AuthService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.domain.repository.UserRepository;
import com.nexorian.tinysteps.infrastructure.jwt.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ServiceResponse<Map<String, Object>> login(String phone) {
        ServiceResponse<Map<String, Object>> response = new ServiceResponse<>();

        try {
            Optional<UserEntity> optionalUser = userRepository.findByPhone(phone);

            if (optionalUser.isEmpty()) {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("User not found");
                response.setStatusCode(404);
                return response;
            }

            UserEntity user = optionalUser.get();

            Map<String, Object> data = new HashMap<>();
            data.put("user", user);
            data.put("token", jwtUtil.generateToken(user.getId().toString()));

            response.setData(data);
            response.setMessage("Login successful");

        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("An error occurred during login");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(500);
        }

        return response;
    }

    @Override
    public ServiceResponse<Map<String, Object>> register(UserEntity user) {
        ServiceResponse<Map<String, Object>> response = new ServiceResponse<>();

        try {
            if (userRepository.findByPhone(user.getPhone()).isPresent()) {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("Phone number already registered");
                response.setStatusCode(409);
                return response;
            }

            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("Email already registered");
                response.setStatusCode(409);
                return response;
            }

            UserEntity savedUser = userRepository.save(user);

            Map<String, Object> data = new HashMap<>();
            data.put("user", savedUser);
            data.put("token", jwtUtil.generateToken(savedUser.getId().toString()));

            response.setData(data);
            response.setMessage("User registered successfully");

        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Registration failed");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(500);
        }

        return response;
    }

    @Override
    public ServiceResponse<UserEntity> validateToken(String token) {
        ServiceResponse<UserEntity> response = new ServiceResponse<>();

        try {
            String userIdStr = jwtUtil.extractUserId(token);
            UUID userId = UUID.fromString(userIdStr);

            Optional<UserEntity> optionalUser = userRepository.findById(userId);

            if (optionalUser.isPresent()) {
                response.setData(optionalUser.get());
                response.setMessage("User validated successfully");
            } else {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("User not found");
                response.setStatusCode(404);
            }

        } catch (IllegalArgumentException e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Invalid token user ID format");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(401);
        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("An error occurred during token validation");
            response.setErrorStackTrace(e.toString());
            response.setStatusCode(500);
        }

        return response;
    }
}
