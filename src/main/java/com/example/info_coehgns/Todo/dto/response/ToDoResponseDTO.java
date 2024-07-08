package com.example.info_coehgns.Todo.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDoResponseDTO {
    private Long id;
    private String content;
    private boolean isDone;
}
