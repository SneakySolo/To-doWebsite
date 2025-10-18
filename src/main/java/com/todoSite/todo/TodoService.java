package com.todoSite.todo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepo repo;

    public TodoService(TodoRepo todoRepo) {
        this.repo = todoRepo;
    }

    public List<Todo> getAllTasks() {
        return repo.findAll();
    }

    public void createTask(String taskTitle) {
        // it must be name of the @Entity not anything else because that particular type of var can hold that type of data
        Todo task = new Todo();

        // even though task and status is lowercase, here in becomes 1st letter capital
        task.setTask(taskTitle);
        task.setStatus("Pending");
        repo.save(task);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

    public void mark(int id) {
        var exists = repo.findById(id).orElse(null);
        if (exists == null) {
            throw new RuntimeException("Task not found");
        }
        exists.setStatus("Done");
        repo.save(exists);
    }
}