package com.nexorian.tinysteps.application.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChildResponseDTO {
    private UUID id;
    private QuestionDTO question;
    private Boolean questionAnswered;
    private Boolean answeredYes;
    private ChildDTO childId;
}
