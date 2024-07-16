package com.sulayman.todo.controllers;

import com.sulayman.todo.dto.TodoDTO;
import com.sulayman.todo.entity.Todo;
import com.sulayman.todo.repository.TodoRepository;
import com.sulayman.todo.services.TodoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Data
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoRepository todoRepository;
    private final TodoService todoService;
    @Autowired
    public TodoController(TodoRepository todoRepository, TodoService todoService) {
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }


    @GetMapping
    public List<TodoDTO> getAllTodos() {
        return todoService.getAllTodosWithUser();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        return  ResponseEntity.ok(createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDetails) {
Todo updatedTodo = todoService.updateTodo(id,todoDetails);
        return ResponseEntity.ok(updatedTodo);

    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Sorry can't find the todo"));
        todoRepository.delete(todo);
    }
}
