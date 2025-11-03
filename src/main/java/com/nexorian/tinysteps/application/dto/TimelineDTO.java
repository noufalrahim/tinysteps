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
public class TimelineDTO {
    private UUID id;
    private ChildDTO child;
    private String title;
    private String description;
    private Date date;
}
