package com.sulayman.todo.dto;

import lombok.Data;

@Data
public class TodoDTO {

    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private UserDTO user;
}
