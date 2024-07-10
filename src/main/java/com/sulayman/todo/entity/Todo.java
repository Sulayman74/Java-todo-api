package com.sulayman.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean completed = Boolean.FALSE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
