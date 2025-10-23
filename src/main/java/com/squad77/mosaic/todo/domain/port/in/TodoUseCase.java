package com.squad77.mosaic.todo.domain.port.in;

import com.squad77.mosaic.todo.domain.model.Todo;
import com.squad77.mosaic.todo.domain.port.in.command.CreateTodoCommand;

import java.util.List;
import java.util.UUID;

public interface TodoUseCase {
    Todo createTodo(CreateTodoCommand command);

    List<Todo> getAllTodos();

    Todo getTodoById(UUID id);

    void completeTodo(UUID id);
}