package com.projects.Task_Management.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projects.Task_Management.dto.CreateTaskRequest;
import com.projects.Task_Management.dto.TaskResponse;
import com.projects.Task_Management.entity.Task;
import com.projects.Task_Management.entity.TaskStatus;
import com.projects.Task_Management.repository.TaskRepository;

// DTO - Entity | mappers
// Bean = Java Object
@Service
// Business Logic
public class TaskService {
    // Dependency Injection (DI).
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(CreateTaskRequest request) {
        // entity - save in repo - return response from saved task by getters
        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getStatus());

        Task savedTask = taskRepository.save(task);
        return new TaskResponse(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getStatus(),
                savedTask.getCreatedAt()

        );

    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream().map(
                t -> new TaskResponse(t.getId(), t.getTitle(), t.getDescription(), t.getStatus(), t.getCreatedAt()))
                .toList();

    }

    public TaskResponse getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Task not found with id: " + taskId));
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt());
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Task not found with id: " + id));

        taskRepository.delete(task);
    }

    public TaskResponse updateTask(Long id, CreateTaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Task not found with id: " + id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(
                request.getStatus() != null
                        ? request.getStatus()
                        : TaskStatus.TODO);

        Task updatedTask = taskRepository.save(task);

        return new TaskResponse(
                updatedTask.getId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.getStatus(),
                updatedTask.getCreatedAt());
    }

}
