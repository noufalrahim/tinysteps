package com.nexorian.tinysteps.application.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private UUID id;
    private UserDTO user;
    private ChildDTO child;
    private String content;
    private String image;
    private Instant createdAt;
    private Instant updatedAt;
}
