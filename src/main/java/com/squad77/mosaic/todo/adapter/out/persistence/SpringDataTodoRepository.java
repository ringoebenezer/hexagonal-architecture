package com.squad77.mosaic.todo.adapter.out.persistence;

import com.squad77.mosaic.todo.domain.model.Todo;
import com.squad77.mosaic.todo.domain.port.out.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SpringDataTodoRepository implements TodoRepository {
    private final JpaTodoRepository jpa;
    private final TodoEntityMapper mapper;

    @Override
    public Todo save(Todo todo) {
        TodoEntity entity = mapper.toEntity(todo);
        return mapper.toDomain(jpa.save(entity));
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Todo> findAll() {
        return jpa.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}