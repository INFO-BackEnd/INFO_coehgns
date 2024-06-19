package com.example.info_coehgns.controller;

import com.example.info_coehgns.service.ToDoService;
import com.example.info_coehgns.dto.request.ToDoRequestDTO;
import com.example.info_coehgns.dto.response.ToDoResponseDTO;
import com.example.info_coehgns.dto.request.UpdateToDoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping()
    public List<ToDoResponseDTO> showAllToDos() {
        return toDoService.showAllToDos();
    }

    @GetMapping("{id}")
    public ToDoResponseDTO toDoFindById(@PathVariable("id") Long id) {
        return toDoService.toDoFindById(id);
    }

    @PostMapping
    public void createToDo(@RequestBody @Validated ToDoRequestDTO toDoRequestDTO) {
        toDoService.createToDo(toDoRequestDTO);
    }

    @PutMapping("{id}")
    public void updateToDo(@PathVariable("id") Long id, @RequestBody @Validated UpdateToDoRequestDTO updateToDoRequestDTO) {
        toDoService.updateToDo(id, updateToDoRequestDTO);
    }

    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable("id") Long id) {
        toDoService.deleteToDo(id);
    }
}