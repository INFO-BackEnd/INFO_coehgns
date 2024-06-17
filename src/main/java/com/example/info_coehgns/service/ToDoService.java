package com.example.info_coehgns.service;

import com.example.info_coehgns.dto.requestdto.ToDoRequestDTO;
import com.example.info_coehgns.dto.responsedto.ToDoResponseDTO;
import com.example.info_coehgns.dto.requestdto.UpdateToDoRequestDTO;
import com.example.info_coehgns.entity.ToDo;
import com.example.info_coehgns.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ToDoResponseDTO toDoFindById(int id) {
         Optional<ToDo> optionalEntity =  toDoRepository.findById(id);
         if(optionalEntity.isEmpty()) {
             throw new IllegalArgumentException();
         }

         return ToDoResponseDTO.builder()
                 .id(optionalEntity.get().getId())
                 .content(optionalEntity.get().getContent())
                 .isDone(optionalEntity.get().isDone())
                 .build();
    }

    public void updateToDo(int id, UpdateToDoRequestDTO updateToDoRequestDTO) {
        Optional<ToDo> optionalEntity = toDoRepository.findById(id);
        if(optionalEntity.isEmpty()) {
            throw new IllegalArgumentException();
        }

        ToDo toDo = optionalEntity.get();
        if(updateToDoRequestDTO.isDone()) {
            toDo.completeToDo();
        } else {
            toDo.cancelToDo();
        }

        toDoRepository.save(toDo);
    }

    public void deleteToDo(int id) {
        toDoRepository.deleteById(id);
    }

}
