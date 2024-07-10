package com.sulayman.todo.services;

import com.sulayman.todo.dto.TodoDTO;
import com.sulayman.todo.dto.UserDTO;
import com.sulayman.todo.entity.Todo;
import com.sulayman.todo.repository.TodoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoDTO> getAllTodosWithUser() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TodoDTO convertToDto(Todo todo) {
        TodoDTO todoDto = new TodoDTO();
        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setDescription(todo.getDescription());
        todoDto.setCompleted(todo.getCompleted());

        // Mapping UserDTO
        UserDTO userDto = new UserDTO();
        userDto.setId(todo.getUser().getId());
        userDto.setTitle(todo.getUser().getTitle());
        userDto.setFirstname(todo.getUser().getFirstname());
        userDto.setLastname(todo.getUser().getLastname());
        userDto.setEmail(todo.getUser().getEmail());

        todoDto.setUser(userDto);

        return todoDto;
    }
}