package com.example.TodoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoApplication.model.Todo;

public interface TodoRepository  extends JpaRepository<Todo,Long>{

} 
 