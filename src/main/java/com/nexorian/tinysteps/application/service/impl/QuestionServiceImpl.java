package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.QuestionService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;
import com.nexorian.tinysteps.domain.repository.QuestionRepository;

@Service
public class QuestionServiceImpl extends BaseServiceImpl<QuestionEntity, UUID> implements QuestionService {
    public QuestionServiceImpl(QuestionRepository questionRepository, JpaSpecificationExecutor<QuestionEntity> specRepository){
        super(questionRepository, specRepository, QuestionEntity.class);
    }
}