package com.example.info_coehgns.Todo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UpdateToDoRequestDTO {
    @NotNull(message = "완료 여부가 null 값일 수 없습니다.")
    private boolean isDone;
}