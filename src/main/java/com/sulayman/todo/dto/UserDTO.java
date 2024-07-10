package com.sulayman.todo.dto;

import lombok.Data;

@Data
public class UserDTO {

        private Long id;
        private String title;
        private String firstname;
        private String lastname;
        private String email;

}
