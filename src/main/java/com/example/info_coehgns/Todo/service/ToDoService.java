package com.example.info_coehgns.Todo.service;

import com.example.info_coehgns.Todo.dto.request.ToDoRequestDTO;
import com.example.info_coehgns.Todo.dto.request.UpdateToDoRequestDTO;
import com.example.info_coehgns.Todo.entity.ToDo;
import com.example.info_coehgns.Todo.dto.response.ToDoResponseDTO;
import com.example.info_coehgns.Todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;
    public List<ToDoResponseDTO> showAllToDos() {
        List<ToDo> toDoList = toDoRepository.findAll();

        return toDoList.stream().map(toDo -> ToDoResponseDTO.builder()
                .id(toDo.getId())
                .content(toDo.getContent())
                .isDone(toDo.isDone())
                .build()).toList();
    }

    public void createToDo(ToDoRequestDTO toDoRequestDTO) {
        ToDo toDo = ToDo.builder()
                .isDone(toDoRequestDTO.isDone())
                .content(toDoRequestDTO.getContent())
                .build();

        toDoRepository.save(toDo);
    }

    public ToDoResponseDTO toDoFindById(Long id) {
         ToDo toDo =  toDoRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("해당 Id를 찾지 못함."));

         return ToDoResponseDTO.builder()
                 .id(toDo.getId())
                 .content(toDo.getContent())
                 .isDone(toDo.isDone())
                 .build();
    }

    @Transactional
    public void updateToDo(Long id, UpdateToDoRequestDTO updateToDoRequestDTO) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 Id를 찿지 못함."));

        if(updateToDoRequestDTO.isDone()) {
            toDo.completeToDo();
        } else {
            toDo.cancelToDo();
        }
    }

    public void deleteToDo(Long id) {
        if(!toDoRepository.existsById(id)) {
            throw new RuntimeException("해당 Id를 찾지 못함.");
        }
        toDoRepository.deleteById(id);
    }

}
