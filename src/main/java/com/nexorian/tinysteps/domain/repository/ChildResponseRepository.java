package com.nexorian.tinysteps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexorian.tinysteps.domain.entity.ChildResponseEntity;


public interface ChildResponseRepository extends JpaRepository<ChildResponseEntity, UUID>, JpaSpecificationExecutor<ChildResponseEntity>{}
