package com.nexorian.tinysteps.application.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionWithAnswerStatusDTO {

    private UUID id;
    private String questionEnglish;
    private String questionMalayalam;
    private Integer severity;
    private Boolean answered;
    private Date achievedOn;
    private String description;
    private String image;

    public QuestionWithAnswerStatusDTO(
            UUID id,
            String questionEnglish,
            String questionMalayalam,
            Integer severity,
            Boolean answered,
            Date achievedOn
    ) {
        this.id = id;
        this.questionEnglish = questionEnglish;
        this.questionMalayalam = questionMalayalam;
        this.severity = severity;
        this.answered = answered;
        this.achievedOn = achievedOn;
    }

    public QuestionWithAnswerStatusDTO(
            UUID id,
            String questionEnglish,
            String questionMalayalam,
            Integer severity,
            Boolean answered,
            Date achievedOn,
            String description,
            String image
    ) {
        this(id, questionEnglish, questionMalayalam, severity, answered, achievedOn);
        this.description = description;
        this.image = image;
    }
}
