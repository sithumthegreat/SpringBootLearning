package com.ijse.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.entity.Task;
import com.ijse.hello.service.TaskService;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskSerivice;

    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task){
        if (task.getTaskName()==null || task.getTaskName()==""){
            return ResponseEntity.status(400).body("please enter a valid task name");
        }
        if (task.getPriority()==null){
            return ResponseEntity.status(400).body("please enter a valid task priority");
        }
        try {
            Task createdTask=taskSerivice.createTask(task);
            return ResponseEntity.status(201).body(createdTask);
            
        } catch (Exception e) {
           
            return ResponseEntity.status(400).body(e.getMessage());
        }
        

    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks=taskSerivice.getAllTasks();
        return ResponseEntity.status(200).body(tasks);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){
        Task task=taskSerivice.getTaskById(taskId);
        if (task==null){
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(task);
        }

    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task){
        Task updatedTask=taskSerivice.updateTask(taskId,task);
        if (updatedTask==null){
            return ResponseEntity.status(400).body(null);
        }else{
            return ResponseEntity.status(200).body(task);
        }


    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskSerivice.deleteTask(taskId);


    }   
    

}
