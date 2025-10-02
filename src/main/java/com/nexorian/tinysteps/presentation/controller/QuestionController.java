package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.QuestionDTO;
import com.nexorian.tinysteps.application.service.QuestionService;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.QuestionMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/questions")
public class QuestionController extends BaseController<QuestionEntity, QuestionDTO, UUID> {

    public QuestionController(QuestionService service) {
        super(service, QuestionMapper::toDTO);
    }
}
