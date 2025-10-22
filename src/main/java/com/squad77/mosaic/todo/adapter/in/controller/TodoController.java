package com.squad77.mosaic.todo.adapter.in.controller;

import com.squad77.mosaic.todo.adapter.in.dto.CreateTodoRequest;
import com.squad77.mosaic.todo.domain.model.Todo;
import com.squad77.mosaic.todo.domain.port.dto.CreateTodoCommand;
import com.squad77.mosaic.todo.domain.port.in.TodoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoUseCase todoUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody CreateTodoRequest request) {
        var command = new CreateTodoCommand(request.title(), request.description());
        return todoUseCase.createTodo(command);
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoUseCase.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable UUID id) {
        return todoUseCase.getTodoById(id);
    }

    @PutMapping("/{id}/complete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void complete(@PathVariable UUID id) {
        todoUseCase.completeTodo(id);
    }
}
