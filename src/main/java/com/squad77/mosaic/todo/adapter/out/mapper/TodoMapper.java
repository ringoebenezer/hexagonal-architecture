package com.squad77.mosaic.todo.adapter.out.mapper;

import com.squad77.mosaic.todo.adapter.in.dto.response.TodoResponse;
import com.squad77.mosaic.todo.domain.model.Todo;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapper {
    public TodoResponse toResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }

    public List<TodoResponse> toResponseList(List<Todo> todos) {
        return todos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
