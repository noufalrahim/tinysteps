package com.nexorian.tinysteps.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nexorian.tinysteps.application.dto.QuestionWithAnswerStatusDTO;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, UUID>, JpaSpecificationExecutor<QuestionEntity> {

@Query("""
    SELECT new com.nexorian.tinysteps.application.dto.QuestionWithAnswerStatusDTO(
        q.id,
        q.questionEnglish,
        q.questionMalayalam,
        q.severity,
        CASE WHEN cr.id IS NOT NULL THEN true ELSE false END,
        cr.achievedOn
    )
    FROM QuestionEntity q
    LEFT JOIN ChildResponseEntity cr
        ON cr.question.id = q.id AND cr.child.id = :childId
    WHERE q.category.id = :categoryId
      AND :ageMonths BETWEEN q.ageGroup.startAge AND q.ageGroup.endAge
""")
List<QuestionWithAnswerStatusDTO> findQuestionsForChild(
        @Param("childId") UUID childId,
        @Param("ageMonths") int ageMonths,
        @Param("categoryId") UUID categoryId);

}
