package com.nexorian.tinysteps.presentation.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.dto.UserDTO;
import com.nexorian.tinysteps.application.service.UserService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.ChildMapper;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.UserMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserEntity, UserDTO, UUID> {

    private final UserService userService;

    public UserController(UserService service) {
        super(service, UserMapper::toDTO);
        this.userService = service;
    }

    /**
     * Update the default child of a user.
     *
     * @param userId   UUID of the user
     * @param childDTO ChildDTO containing the child information
     * @return ServiceResponse<UserEntity>
     */
    @PatchMapping("/{userId}/default-child")
    public ResponseEntity<ServiceResponse<UserEntity>> updateDefaultChild(
            @PathVariable UUID userId,
            @RequestBody ChildDTO childDTO) {

        ServiceResponse<Optional<UserEntity>> userResponse = userService.findById(userId);

        if (userResponse.getData() == null || userResponse.getData().isEmpty()) {
            ServiceResponse<UserEntity> response = new ServiceResponse<>();
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("User not found");
            response.setStatusCode(404);
            return ResponseEntity.status(404).body(response);
        }

        UserEntity user = userResponse.getData().get();

        ChildEntity child = ChildMapper.toEntity(childDTO);
        child.setUser(user);

        ServiceResponse<UserEntity> response = userService.updateDefaultChild(child);

        return ResponseEntity
                .status(response.getStatusCode() > 0 ? response.getStatusCode() : 200)
                .body(response);
    }

}
