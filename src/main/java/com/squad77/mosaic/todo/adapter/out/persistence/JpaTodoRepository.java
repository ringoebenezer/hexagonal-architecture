package com.squad77.mosaic.todo.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface JpaTodoRepository extends JpaRepository<TodoEntity,UUID> {}