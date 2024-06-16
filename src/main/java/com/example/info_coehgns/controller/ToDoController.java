package com.example.info_coehgns.controller;

import com.example.info_coehgns.service.ToDoService;
import com.example.info_coehgns.dto.RequestDTO.ToDoRequestDTO;
import com.example.info_coehgns.dto.ResponseDTO.ToDoResponseDTO;
import com.example.info_coehgns.dto.RequestDTO.UpdateToDoRequestDTO;
import lombok.RequiredArgsConstructor;
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
    public ToDoResponseDTO ToDoFindById(@PathVariable("id") int id) {
        return toDoService.ToDoFindById(id);
    }

    @PostMapping
    public void createToDo(@RequestBody ToDoRequestDTO toDoRequestDto) {
        toDoService.createToDo(toDoRequestDto);
    }

    @PutMapping("{id}")
    public void updateToDo(@PathVariable("id") int id, @RequestBody UpdateToDoRequestDTO updateToDoRequestDTO) {
        toDoService.updateToDo(id, updateToDoRequestDTO);
    }

    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable("id") int id) {
        toDoService.deleteToDo(id);
    }
}