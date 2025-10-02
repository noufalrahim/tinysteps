package com.nexorian.tinysteps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;

public interface AgeGroupRepository extends JpaRepository<AgeGroupEntity, UUID>, JpaSpecificationExecutor<AgeGroupEntity> {}
