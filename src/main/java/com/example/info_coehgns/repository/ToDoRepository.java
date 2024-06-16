package com.example.info_coehgns.repository;

import com.example.info_coehgns.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}