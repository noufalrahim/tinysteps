package com.nexorian.tinysteps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexorian.tinysteps.domain.entity.MedicineEntity;


public interface MedicineRepository extends JpaRepository<MedicineEntity, UUID>, JpaSpecificationExecutor<MedicineEntity>{}
