package Kase.TaskManagementSystem.services;

import Kase.TaskManagementSystem.models.User;
import Kase.TaskManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// User Service
@Service
public class UserService implements IUserService {

    // Dependency injection
    @Autowired
    private UserRepository userRepository;

    // find all users
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // find a user by your ID
    @Override
    public User findUserById(int idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    // save a user
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // delete a user
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
