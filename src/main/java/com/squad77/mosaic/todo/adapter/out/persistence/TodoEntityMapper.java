package com.squad77.mosaic.todo.adapter.out.persistence;

import com.squad77.mosaic.todo.domain.model.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoEntityMapper {
    public Todo toDomain(TodoEntity entity) {
        return Todo.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .completed(entity.isCompleted())
                .build();
    }

    public TodoEntity toEntity(Todo domain) {
        return TodoEntity.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .description(domain.getDescription())
                .completed(domain.isCompleted())
                .build();
    }
}
