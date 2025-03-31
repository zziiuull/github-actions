package com.githubactions.repository;

import com.githubactions.models.task.Task;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryTaskRepository implements GenericRepository<UUID, Task>{
    Map<UUID, Task> tasks = new HashMap<>();
    
    @Override
    public Task create(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task find(UUID uuid) {
        return tasks.get(uuid);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public void update(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.replace(task.getId(), task);
        }
    }

    @Override
    public void delete(UUID uuid) {
        tasks.remove(uuid);
    }
}
