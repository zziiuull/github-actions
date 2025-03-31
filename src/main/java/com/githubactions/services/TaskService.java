package com.githubactions.services;

import com.githubactions.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.githubactions.models.task.Task;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    GenericRepository<UUID, Task> repository;

    public Task getTask(UUID taskId){
        return repository.find(taskId);
    }

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.create(task);
    }

    public void updateTask(Task task) {
        repository.update(task);
    }

    public void deleteTask(UUID taskId) {
        repository.delete(taskId);
    }
}
