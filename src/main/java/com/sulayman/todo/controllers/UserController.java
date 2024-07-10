package com.sulayman.todo.controllers;

import com.sulayman.todo.entity.User;
import com.sulayman.todo.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Sorry no user found"));
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

