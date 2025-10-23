package com.squad77.mosaic.todo.adapter.in.dto.response;

import java.util.UUID;

public record TodoResponse(
        UUID id,
        String title,
        String description,
        boolean completed
) {}
