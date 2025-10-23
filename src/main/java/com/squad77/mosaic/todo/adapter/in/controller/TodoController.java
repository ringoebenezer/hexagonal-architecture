package com.squad77.mosaic.todo.adapter.in.controller;

import com.squad77.mosaic.todo.adapter.in.dto.request.CreateTodo;
import com.squad77.mosaic.todo.adapter.in.dto.response.TodoResponse;
import com.squad77.mosaic.todo.adapter.out.mapper.TodoMapper;
import com.squad77.mosaic.todo.domain.port.in.command.CreateTodoCommand;
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
    private final TodoMapper todoMapper;
    private final TodoUseCase todoUseCase;

    public TodoResponse create(@RequestBody CreateTodo request) {
        var command = new CreateTodoCommand(request.title(), request.description());
        var todo = todoUseCase.createTodo(command);
        return todoMapper.toResponse(todo);
    }

    @GetMapping
    public List<TodoResponse> getAll() {
        return todoMapper.toResponseList(todoUseCase.getAllTodos());
    }

    @GetMapping("/{id}")
    public TodoResponse getById(@PathVariable UUID id) {
        return todoMapper.toResponse(todoUseCase.getTodoById(id));
    }

    @PutMapping("/{id}/complete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void complete(@PathVariable UUID id) {
        todoUseCase.completeTodo(id);
    }
}
