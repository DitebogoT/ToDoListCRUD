package org.ditebogo.todolist.Repository;

import org.ditebogo.todolist.Entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

    boolean existsById(Long aLong);

    Optional<ToDoList> findByID (Long Id);
}
