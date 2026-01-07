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

public class TipsDTO {
    private UUID id;
    private String title;
    private String description;
    private String image;
    private String link;
    private AgeGroupDTO ageGroup;
}