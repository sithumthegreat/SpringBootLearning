package com.ijse.hello.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Task;

@Service
public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(long id);
    Task updateTask(Long id,Task task);
    void deleteTask(Long id);

}
