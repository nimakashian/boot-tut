package com.example.todorabbitmq.repository;



import com.example.todorabbitmq.model.ToDo;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
