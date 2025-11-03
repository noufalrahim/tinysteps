package com.nexorian.tinysteps.presentation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.service.AuthService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ServiceResponse<UserEntity>> login(@RequestBody Map<String, String> body) {

        String phone = body.get("phone"); 
        ServiceResponse<UserEntity> response = authService.login(phone);

        HttpStatus status = HttpStatus.OK;

        if (response.getStatus() == ServiceResponse.ResStatus.ERROR) {
            status = HttpStatus.valueOf(response.getStatusCode() > 0 ? response.getStatusCode() : 400);
        }

        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/register")
    public ResponseEntity<ServiceResponse<UserEntity>> register(@RequestBody UserEntity user) {
        ServiceResponse<UserEntity> response = authService.register(user);
        HttpStatus status = HttpStatus.CREATED;

        if (response.getStatus() == ServiceResponse.ResStatus.ERROR) {
            status = HttpStatus.valueOf(response.getStatusCode() > 0 ? response.getStatusCode() : 400);
        }

        return new ResponseEntity<>(response, status);
    }
}
