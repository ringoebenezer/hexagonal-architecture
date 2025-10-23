package com.squad77.mosaic.todo.domain.service;

import com.squad77.mosaic.todo.domain.model.Todo;
import com.squad77.mosaic.todo.domain.port.in.command.CreateTodoCommand;
import com.squad77.mosaic.todo.domain.port.in.TodoUseCase;
import com.squad77.mosaic.todo.domain.port.out.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService implements TodoUseCase {
    private final TodoRepository todoRepository;

    @Override
    public Todo createTodo(CreateTodoCommand command) {
        Todo todo = Todo.builder()
                .id(UUID.randomUUID())
                .title(command.title())
                .description(command.description())
                .completed(false)
                .build();

        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found"));
    }

    @Override
    public void completeTodo(UUID id) {
        Todo todo = getTodoById(id);
        todo.setCompleted(true);

        todoRepository.save(todo);
    }
}