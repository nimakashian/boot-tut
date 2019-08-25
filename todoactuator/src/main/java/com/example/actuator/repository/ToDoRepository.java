package com.example.actuator.repository;


import com.example.actuator.domain.ToDo;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepository extends CrudRepository<ToDo,String> {

    public long countByCompleted(boolean completed);
}
