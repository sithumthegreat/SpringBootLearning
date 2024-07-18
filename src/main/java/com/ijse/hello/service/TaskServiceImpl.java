package com.ijse.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Task;
import com.ijse.hello.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    // public TaskServiceImpl(TaskRepository taskRepository){
    //     this.taskRepository=taskRepository;
    // }

    @Override
    public Task createTask(Task task){
        //create task in database
        return taskRepository.save(task);
    }
    @Override
    public List<Task> getAllTasks(){
        //view task array fetched from database
        return taskRepository.findAll();

    }
    @Override
    public Task getTaskById(long id) {
        // TODO Auto-generated method stub
        return taskRepository.findById(id).orElse(null);
    }
    @Override
    public Task updateTask(Long Id, Task task){
        Task existingTask=taskRepository.findById(Id).orElse(null);
        if (existingTask==null){
            return null;
        }else{
            existingTask.setTaskName(task.getTaskName());
            existingTask.setPriority(task.getPriority());
            existingTask.setDuedate(task.getDuedate());
            return taskRepository.save(existingTask);
        }

    } 

    @Override
    public void deleteTask(Long Id){
        taskRepository.deleteById(Id);
       

    }
    
   
    


} 
