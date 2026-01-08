package com.nexorian.tinysteps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexorian.tinysteps.domain.entity.TipsEntity;

public interface TipsRepository extends JpaRepository<TipsEntity, UUID> {}