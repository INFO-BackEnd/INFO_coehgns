package com.example.info_coehgns.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private boolean isDone;

    public void completeToDo() {
        this.isDone = true;
    }
    public void cancelToDo() {
        this.isDone = false;
    }

}
