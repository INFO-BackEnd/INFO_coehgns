package com.example.info_coehgns.dto.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UpdateToDoRequestDTO {
    @NotBlank
    private boolean isDone;
}
