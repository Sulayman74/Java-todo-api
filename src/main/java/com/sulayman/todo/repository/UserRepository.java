package com.sulayman.todo.repository;

import com.sulayman.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT t FROM Todo t")
    List<User> findAllUsers();

    User findUserById(Long id);
}
