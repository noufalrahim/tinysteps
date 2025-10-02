package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.AgeGroupDTO;
import com.nexorian.tinysteps.application.dto.CategoryDTO;
import com.nexorian.tinysteps.application.dto.QuestionDTO;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;

public class QuestionMapper {

    public static QuestionDTO toDTO(QuestionEntity question) {
        if (question == null) return null;

        CategoryDTO categoryDTO = question.getCategory() != null
            ? CategoryMapper.toDTO(question.getCategory())
            : null;

        AgeGroupDTO ageGroupDTO = question.getAgeGroup() != null
            ? AgeGroupMapper.toDTO(question.getAgeGroup())
            : null;

        return new QuestionDTO(
            question.getId(),
            question.getQuestionEnglish(),
            question.getQuestionMalayalam(),
            question.getSeverity(),
            categoryDTO,
            ageGroupDTO
        );
    }
}
