package com.example.todojms.repositories;


import com.example.todojms.domain.ToDo;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
