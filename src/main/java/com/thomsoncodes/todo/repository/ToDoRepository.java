package com.thomsoncodes.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.thomsoncodes.todo.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, String> {}
