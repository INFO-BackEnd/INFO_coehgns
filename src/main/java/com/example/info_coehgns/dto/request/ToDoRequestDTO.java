package com.example.info_coehgns.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ToDoRequestDTO {
    @NotNull(message = "content가 null 값일 수 없습니다.")
    private String content;
    @NotNull(message = "완료 여부가 null 값일 수 없습니다.")
    private boolean isDone;
}