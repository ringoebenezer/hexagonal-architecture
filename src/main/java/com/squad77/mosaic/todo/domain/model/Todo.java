package com.squad77.mosaic.todo.domain.model;

import lombok.*;

import java.util.UUID;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private UUID id;
    private String title;
    private String description;
    private boolean completed;
}
