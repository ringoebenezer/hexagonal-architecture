package com.squad77.mosaic.todo.domain.port.out;

import com.squad77.mosaic.todo.domain.model.Todo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {
    Todo save(Todo todo);
    Optional<Todo> findById(UUID id);
    List<Todo> findAll();
}