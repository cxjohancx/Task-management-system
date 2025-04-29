package Kase.TaskManagementSystem.services;

import Kase.TaskManagementSystem.models.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> getTasks();
    public Task findTaskById(int idTask);
    public void saveTask(Task task);
    public void deleteTask(Task task);
}
