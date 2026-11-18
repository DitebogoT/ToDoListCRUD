package org.ditebogo.todolist.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ToDoListResponse(
        Long id,
        String taskName,
        String description,
        LocalDateTime dueDate,
        LocalDateTime dateCreated,
        boolean taskDone
) {
}
