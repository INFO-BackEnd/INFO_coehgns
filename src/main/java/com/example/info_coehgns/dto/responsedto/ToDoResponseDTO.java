package com.example.info_coehgns.dto.responsedto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDoResponseDTO {
    private int id;
    private String content;
    private boolean isDone;
}
