package Kase.TaskManagementSystem.controllers;

import Kase.TaskManagementSystem.models.User;
import Kase.TaskManagementSystem.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class UsersController {
    private static Logger logger = LoggerFactory.getLogger(UsersController.class);

    // Inyeccion del servicio
    @Autowired
    UserService userService;

    // Metodo para mostrar los usuarios en la tabla
    @GetMapping("/userPage")
    public String listUsers(ModelMap model) {
        // Listar usuarios
        model.addAttribute("users", userService.getUsers());

        // Objeto user para el formulario
        model.addAttribute("userForm", new User());

        return "userPage";
    }

    // Metodo para agregar un usuario
    @PostMapping("/user_add")
    public String addUser(@ModelAttribute ("userForm") User user){
        logger.info("Contacto a agregar: " + user);

        // Guardar usuario
        userService.saveUser(user);

        return "redirect:/userPage";
    }

    // Metodo para editar un usuario
    @GetMapping("/user_update/{id}")
    public String updateUser(@PathVariable(value = "id") @ModelAttribute("userForm") User userForm){

        // Obtener id del usuario a modificar
        userForm.setIdUser(userForm.getIdUser());

        logger.info("Usuario a editar: " + userForm);

        // Guardar el usuario modificado
        userService.saveUser(userForm);

        return "redirect:/userPage";

    }

    // Metodo para eliminar el usuario
    @GetMapping("/user_delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int idUser){
        // Objeto nuevo user
        User user = new User();

        // Darle el id del usuario a eliminar al objeto
        user.setIdUser(idUser);

        // Borrar ese usuario
        userService.deleteUser(user);

        // Redireccionar a inicio
        return "redirect:/userPage";
    }
}
