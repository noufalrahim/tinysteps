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
public class AgeGroupDTO {
    private UUID id;
    private Integer startAge;
    private Integer endAge;
}
