package com.nexorian.tinysteps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexorian.tinysteps.domain.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, UUID>, JpaSpecificationExecutor<AdminEntity>{}
