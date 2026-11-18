package org.ditebogo.todolist.Repository;

import org.ditebogo.todolist.Entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

    boolean existsById(Long id);

    Optional<ToDoList> findById(Long id);

    Optional<ToDoList> findByTaskName(String taskName);

    List<ToDoList> findByTaskDone(boolean taskDone);
}
