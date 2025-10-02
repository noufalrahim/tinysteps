package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.AdminService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.AdminEntity;
import com.nexorian.tinysteps.domain.repository.AdminRepository;

@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminEntity, UUID> implements AdminService {
    public AdminServiceImpl(AdminRepository adminRepository, JpaSpecificationExecutor<AdminEntity> specRepository){
        super(adminRepository, specRepository, AdminEntity.class);
    }
}
