package com.sulayman.todo.repository;

import com.sulayman.todo.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Query("SELECT t FROM Todo t JOIN FETCH t.user")
    List<Todo> findAllWithUser();

    List<Todo> findAllByUserId(Long userId);

}
