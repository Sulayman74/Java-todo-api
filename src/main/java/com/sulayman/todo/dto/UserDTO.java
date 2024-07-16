package com.sulayman.todo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

        private Long id;
        private String title;
        private String firstname;
        private String lastname;
        private String email;
}


