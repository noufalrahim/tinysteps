package com.nexorian.tinysteps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nexorian.tinysteps.domain.entity.AgeGroupEntity;

public interface AgeGroupRepository extends JpaRepository<AgeGroupEntity, UUID>, JpaSpecificationExecutor<AgeGroupEntity> {
    @Query("""
        SELECT COUNT(a) > 0
        FROM AgeGroupEntity a
        WHERE a.startAge <= :endAge
          AND a.endAge   >= :startAge
    """)
    boolean existsOverlappingRange(
        @Param("startAge") Integer startAge,
        @Param("endAge") Integer endAge
    );
}
