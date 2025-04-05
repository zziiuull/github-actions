package com.githubactions.services;

import com.githubactions.models.task.Task;
import com.githubactions.repository.GenericRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private GenericRepository<UUID, Task> repository;

    @InjectMocks
    private TaskService service;

    @Test
    void getTask() {
        UUID taskId = UUID.randomUUID();
        Task t = new Task();
        when(repository.find(taskId)).thenReturn(t);
        Task task = service.getTask(taskId);
        assertThat(task).isEqualTo(t);
    }
}