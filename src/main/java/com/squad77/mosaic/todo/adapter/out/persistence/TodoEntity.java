package com.squad77.mosaic.todo.adapter.out.persistence;

import com.squad77.mosaic.shared.adapter.out.persistence.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "todos")
@Getter @Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TodoEntity extends BaseEntity {
    private String title;
    private String description;
    private boolean completed;
}