package com.example.security.simplesecurity.repository;

import com.example.security.simplesecurity.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
