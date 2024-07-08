package com.example.info_coehgns.Todo.repository;

import com.example.info_coehgns.Todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}