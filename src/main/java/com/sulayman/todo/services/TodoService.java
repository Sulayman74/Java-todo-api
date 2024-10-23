package com.sulayman.todo.services;

import com.sulayman.todo.dto.TodoDTO;
import com.sulayman.todo.dto.UserDTO;
import com.sulayman.todo.entity.Todo;
import com.sulayman.todo.repository.TodoRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Transactional(readOnly = true)
    public List<TodoDTO> getAllTodosWithUser() {
        List<Todo> todos = todoRepository.findAllWithUser();

        return todos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Sorry Todo not found"));
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
public Todo updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = findById(id);
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        return todoRepository.save(todo);
}
    public List<TodoDTO> getTodosByUserId(Long userId) {
        List<Todo> todos = todoRepository.findAllByUserId(userId);

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