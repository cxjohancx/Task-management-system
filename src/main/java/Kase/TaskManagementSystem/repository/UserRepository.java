package Kase.TaskManagementSystem.repository;

import Kase.TaskManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
