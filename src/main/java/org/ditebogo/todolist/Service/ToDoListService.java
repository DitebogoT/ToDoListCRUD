package org.ditebogo.todolist.Service;

import org.ditebogo.todolist.Entity.ToDoList;
import org.ditebogo.todolist.DTO.ToDoListRequest;
import org.ditebogo.todolist.DTO.ToDoListResponse;
import org.ditebogo.todolist.Repository.ToDoListRepo;
import org.ditebogo.todolist.Exceptions.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToDoListService {

    private final ToDoListRepo toDoListRepo;

    public ToDoListService(ToDoListRepo toDoListRepo)
    {
        this.toDoListRepo = toDoListRepo;
    }

    @Transactional
    public ToDoListResponse createTask(ToDoListRequest request){

        ToDoList toDoList = new ToDoList();
        toDoList.setTaskName(request.taskName());
        toDoList.setDescription(request.description());
        toDoList.setDueDate(request.dueDate().atStartOfDay());

        ToDoList savedToDoList = toDoListRepo.save(toDoList);

        return mapToResponse(savedToDoList);
    }

    //Read All
    @Transactional(readOnly = true)
    public List<ToDoListResponse> getAllTasks() {

        return toDoListRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    //Reads one
    @Transactional(readOnly = true)
    public ToDoListResponse getTaskByID(Long id)
    {
        ToDoList toDoList = findTaskOrThrow(id);

        return  mapToResponse(toDoList);
    }

    //Update
    @Transactional
    public ToDoListResponse updateTask(Long id, ToDoListRequest request) {


        ToDoList toDoList = findTaskOrThrow(id);

        toDoList.setTaskName(request.taskName());
        toDoList.setDescription(request.description());
        toDoList.setDueDate(request.dueDate().atStartOfDay());

        ToDoList updatedTask = toDoListRepo.save(toDoList);

        return mapToResponse(updatedTask);


    }


    //Delete
    @Transactional
    public void deleteTask(Long id) {

        ToDoList toDoList = findTaskOrThrow(id);

        toDoListRepo.delete(toDoList);
    }

    private ToDoList findTaskOrThrow(Long id) {

        return toDoListRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Task with ID: " + id + " not found."
        ));

    }


    private ToDoListResponse mapToResponse (ToDoList toDoList)
    {

        return new ToDoListResponse(
                toDoList.getId(),
                toDoList.getTaskName(),
                toDoList.getDescription(),
                toDoList.getDateCreated(),
                toDoList.getDueDate(),
                toDoList.isTaskDone()
        );
    }
}
