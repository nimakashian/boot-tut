package com.example.redis.repository;



import com.example.redis.domain.ToDo;
import org.springframework.data.repository.CrudRepository;


public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
