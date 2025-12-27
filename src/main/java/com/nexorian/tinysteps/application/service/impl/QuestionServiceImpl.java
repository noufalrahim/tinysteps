package com.nexorian.tinysteps.application.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.dto.QuestionWithAnswerStatusDTO;
import com.nexorian.tinysteps.application.service.QuestionService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.application.wrapper.ServiceResponse;
import com.nexorian.tinysteps.domain.entity.ChildEntity;
import com.nexorian.tinysteps.domain.entity.QuestionEntity;
import com.nexorian.tinysteps.domain.repository.ChildRepository;
import com.nexorian.tinysteps.domain.repository.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuestionServiceImpl extends BaseServiceImpl<QuestionEntity, UUID> implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ChildRepository childRepository;

    public QuestionServiceImpl(
            QuestionRepository questionRepository,
            JpaSpecificationExecutor<QuestionEntity> specRepository,
            ChildRepository childRepository) {
        super(questionRepository, specRepository, QuestionEntity.class);
        this.questionRepository = questionRepository;
        this.childRepository = childRepository;
    }

    @Override
    public ServiceResponse<List<QuestionWithAnswerStatusDTO>> getQuestionsForChild(UUID childId, UUID categoryId) {

        ServiceResponse<List<QuestionWithAnswerStatusDTO>> response = new ServiceResponse<>();
        try {
            ChildEntity child = childRepository.findById(childId)
                    .orElseThrow(() -> new RuntimeException("Child not found"));

            int ageMonths = Period.between(child.getDateOfBirth(), LocalDate.now()).getMonths()
                    + Period.between(child.getDateOfBirth(), LocalDate.now()).getYears() * 12;

            System.out.println("childId: " + childId + ", categoryId: " + categoryId + ", ageMonths: " + ageMonths);

            log.info("childId: {}, categoryId: {}, ageMonths: {}", childId, categoryId, ageMonths);
            List<QuestionWithAnswerStatusDTO> questions;

            if (categoryId == null) {
                questions = questionRepository.findQuestionsForChildAcrossAllCategories(
                        childId,
                        ageMonths);
            } else {
                questions = questionRepository.findQuestionsForChild(
                        childId,
                        ageMonths,
                        categoryId);
            }
            response.setData(questions);
            response.setMessage("Questions fetched successfully");
        } catch (Exception e) {
            response.setStatus(ServiceResponse.ResStatus.ERROR);
            response.setMessage("Failed to fetch questions");
            response.setErrorStackTrace(e.toString());
        }
        return response;
    }

}
