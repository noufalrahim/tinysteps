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
public class AdminDTO {
    private UUID id;
    private String name;
    private boolean isSuperAdmin;
    private boolean hasEditAccess;
    private boolean hasDeleteAccess;
}
