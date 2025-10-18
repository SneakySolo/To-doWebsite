package com.todoSite.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository <Todo,Integer> {

}
