package com.example.info_coehgns.Todo.entity;

import com.example.info_coehgns.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void completeToDo() {
        this.isDone = true;
    }
    public void cancelToDo() {
        this.isDone = false;
    }

}
