package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.UserService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.domain.entity.UserEntity;
import com.nexorian.tinysteps.domain.repository.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UUID> implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, JpaSpecificationExecutor<UserEntity> specRepository) {
        super(userRepository, specRepository, UserEntity.class);
        this.userRepository = userRepository;
    }

    @Override
    public ServiceResponse<UserEntity> updateDefaultChild(ChildEntity child) {
        ServiceResponse<UserEntity> response = new ServiceResponse<>();
        try {

            if (child == null || child.getUser() == null) {
                response.setStatus(ServiceResponse.ResStatus.ERROR);
                response.setMessage("Child or associated user is null");
                response.setStatusCode(400);
                return response;
            }

            UserEntity user = child.getUser();

            // Persist the child first if it's new
            if (child.getId() == null) {
                // Save the child using child repository
                // childRepository.save(child);  // inject ChildRepository if needed
            }

            user.setDefaultChild(child);

            UserEntity updatedUser = userRepository.save(user);

            response.setData(updatedUser);
            response.setMessage("Default child updated successfully");
            response.setStatus(ServiceResponse.ResStatus.SUCCESS);
            response.setStatusCode(200);

        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Failed to update default child");
            response.setErrorStackTrace(e.getMessage());
            response.setStatusCode(500);
        }

        return response;
    }
}
