package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.dto.ChildResponseDTO;
import com.nexorian.tinysteps.application.dto.QuestionDTO;
import com.nexorian.tinysteps.domain.entity.ChildResponseEntity;

public class ChildResponseMapper {

    public static ChildResponseDTO toDTO(ChildResponseEntity childResponse) {
        if (childResponse == null) return null;

        QuestionDTO questionDTO = childResponse.getQuestion() != null
            ? QuestionMapper.toDTO(childResponse.getQuestion())
            : null;

        ChildDTO childDTO = childResponse.getChild() != null
            ? ChildMapper.toDTO(childResponse.getChild())
            : null;

        return new ChildResponseDTO(
            childResponse.getId(),
            questionDTO,
            childResponse.getQuestionAnswered(),
            childResponse.getAnsweredYes(),
            childDTO,
            childResponse.getAchievedOn()
        );
    }
}
