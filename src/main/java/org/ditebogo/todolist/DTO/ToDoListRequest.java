package org.ditebogo.todolist.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;


public record ToDoListRequest(

        @NotBlank(message = "Task name cannot be empty")
        @Size(max = 100, message = "Task name must not exceed 100 characters")
        String taskName,

        @NotBlank(message = "Description cannot be empty")
        @Size(max = 250, message = "Description must not exceed 250 characters")
        String description,

        @NotNull(message = "Due date cannot be empty")
        LocalDate dueDate

        )
{

}
