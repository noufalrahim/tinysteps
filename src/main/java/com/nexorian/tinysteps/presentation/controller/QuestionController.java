package com.nexorian.tinysteps.presentation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.QuestionDTO;
import com.nexorian.tinysteps.application.dto.QuestionWithAnswerStatusDTO;
import com.nexorian.tinysteps.application.service.QuestionService;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.QuestionMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/questions")
public class QuestionController extends BaseController<QuestionEntity, QuestionDTO, UUID> {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        super(questionService, QuestionMapper::toDTO);
        this.questionService = questionService;
    }

    @GetMapping("/children/{childId}")
    public ServiceResponse<List<QuestionWithAnswerStatusDTO>> getQuestionsForChild(
            @PathVariable UUID childId,
            @RequestParam(required = false) UUID categoryId) {
        return questionService.getQuestionsForChild(childId, categoryId);
    }

}
