package com.nexorian.tinysteps.application.service;

import java.util.List;
import java.util.UUID;

import com.nexorian.tinysteps.application.dto.QuestionWithAnswerStatusDTO;
import com.nexorian.tinysteps.application.service.base.BaseService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;

public interface QuestionService extends BaseService<QuestionEntity, UUID> {
    ServiceResponse<List<QuestionWithAnswerStatusDTO>> getQuestionsForChild(UUID childId, UUID categoryId);
}
