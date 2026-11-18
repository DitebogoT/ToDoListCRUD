package org.ditebogo.todolist.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_created",nullable = false)
    private Date dateCreated;

    @Column(name = "due_date",nullable = false)
    private Date dueDate;

    @Column(name = "isTaskDone", unique = false, nullable = false)
    private boolean isTaskDone;
}
