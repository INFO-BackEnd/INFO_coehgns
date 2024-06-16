package com.example.info_coehgns.dto.ResponseDTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDoResponseDTO {
    private int id;
    private String description;
    private boolean isDone;
}
