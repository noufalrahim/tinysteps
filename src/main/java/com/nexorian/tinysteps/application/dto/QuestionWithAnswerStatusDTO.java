package com.nexorian.tinysteps.application.dto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWithAnswerStatusDTO {
    private UUID id;
    private String questionEnglish;
    private String questionMalayalam;
    private Integer severity;
    private Boolean answered;
    private Date achievedOn;
}
