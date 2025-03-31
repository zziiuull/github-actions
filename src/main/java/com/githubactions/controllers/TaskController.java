package com.githubactions.controllers;

import com.githubactions.models.task.Task;
import com.githubactions.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/id")
    ResponseEntity<Task> getTask(UUID id){
        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody Task task){
        Task created = taskService.createTask(task);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    ResponseEntity<Task> updateTask(@RequestBody Task task){
        taskService.updateTask(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping
    ResponseEntity<Void> deleteTask(UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
