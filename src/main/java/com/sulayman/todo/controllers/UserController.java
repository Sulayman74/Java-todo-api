package com.sulayman.todo.controllers;

import com.sulayman.todo.dto.UserDTO;
import com.sulayman.todo.entity.User;
import com.sulayman.todo.repository.UserRepository;
import com.sulayman.todo.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private UserService userService;
    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;

    }

    @GetMapping
    public List<UserDTO> getAllUsers() {return userService.findAll();}

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User user= userRepository.findById(id).orElseThrow(()-> new RuntimeException("Sorry did not find the user"));
        user.setEmail(userDetails.getEmail());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setTitle(userDetails.getTitle());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("Sorry user not found"));
        userRepository.delete(user);
    }
}

