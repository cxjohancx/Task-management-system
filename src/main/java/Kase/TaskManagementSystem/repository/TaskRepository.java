package Kase.TaskManagementSystem.repository;

import Kase.TaskManagementSystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
