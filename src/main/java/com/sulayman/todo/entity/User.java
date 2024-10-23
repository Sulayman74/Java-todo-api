package com.sulayman.todo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 250)
    private String email;
    @Column(length = 250)
    private String firstname;
    @Column(length = 250)
    private String lastname;
    @Column(length = 250)
    private String password;
    @Column(length = 250)
    private String title;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Todo> todoList;
}
