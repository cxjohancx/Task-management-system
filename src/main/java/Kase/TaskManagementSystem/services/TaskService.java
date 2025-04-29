package Kase.TaskManagementSystem.services;

import Kase.TaskManagementSystem.models.Task;
import Kase.TaskManagementSystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Task Service
@Service
public class TaskService implements ITaskService {

    // Dependency Injection
    @Autowired
    private TaskRepository taskRepository;

    // find and get all the tasks
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    // Find and get a task by your ID
    @Override
    public Task findTaskById(int idTask) {
        return taskRepository.findById(idTask).orElse(null);
    }

    // Save a task
    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    // Delete a task
    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
