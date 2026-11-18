package org.ditebogo.todolist.Controllers;

import org.ditebogo.todolist.DTO.ToDoListRequest;
import org.ditebogo.todolist.DTO.ToDoListResponse;
import org.ditebogo.todolist.Service.ToDoListService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todolist")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService)
    {
        this.toDoListService = toDoListService;
    }

    //create
    @PostMapping
    public ResponseEntity<ToDoListResponse> createTask(
            @Valid @RequestBody ToDoListRequest request) {

        ToDoListResponse response =
                toDoListService.createTask(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    //read all
    @GetMapping
    public ResponseEntity<List<ToDoListResponse>> getAllTasks() {

        return ResponseEntity.ok(
                toDoListService.getAllTasks()
        );
    }
    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ToDoListResponse> getTaskById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                toDoListService.getTaskByID(id)
        );
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<ToDoListResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody ToDoListRequest request) {

        return ResponseEntity.ok(
                toDoListService.updateTask(id, request)
        );
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id) {

        toDoListService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }

}
