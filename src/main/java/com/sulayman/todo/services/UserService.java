package com.sulayman.todo.services;

import com.sulayman.todo.dto.UserDTO;
import com.sulayman.todo.entity.User;
import com.sulayman.todo.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAllUsers();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    private UserDTO convertToDto(User user) {


        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setTitle(user.getTitle());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        return userDto;
    }






}
