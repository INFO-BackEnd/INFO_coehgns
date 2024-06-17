package com.example.info_coehgns.dto.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ToDoRequestDTO {
    @NotBlank
    private String content;
    @NotBlank
    private boolean isDone;
}