package com.sulayman.todo.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean completed = Boolean.FALSE;
    @Column(length = 500)
    private String description;
    private Long id;
    @Column(length = 100)
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
