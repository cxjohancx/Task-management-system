package Kase.TaskManagementSystem.services;

import Kase.TaskManagementSystem.models.User;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    public User findUserById(int idUser);
    public void saveUser(User user);
    public void deleteUser(User user);
}
