package Kase.TaskManagementSystem.controllers;

import Kase.TaskManagementSystem.models.Task;
import Kase.TaskManagementSystem.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    //Inyeccion de dependencia
    @Autowired
    TaskService taskService;

    //Lista de tareas y log
    private List<Task> tasks;
    private static final Logger logger = LoggerFactory.getLogger(TasksController.class);

    //Página principal
    @GetMapping("/taskPage")
    public String iniciar(ModelMap model){

        List<Task> tasks = taskService.getTasks();

        tasks.forEach((task) -> logger.info(task.toString()));

        model.put("tasks", tasks);

        return "taskPage";
    }

    //Pagina para el formulario de agregar
    @GetMapping("/taskPage/add")
    public String viewAddTask(){

        return "addTask";
    }

    /*Metodo agregar
    */

    @PostMapping("/taskPage/add")
    public String addTask(@ModelAttribute("taskForm") Task task){

        logger.info("Task a agregar: " + task);
        taskService.saveTask(task);

        return "taskPage";
    }

    //Procesamiento para la pagina editar
    @GetMapping("/task/edit")
    public String viewEditTask(@PathVariable(value = "idTask") int idTask, ModelMap modelo){

        Task task = taskService.findTaskById(idTask);
        logger.info("Contacto a editar: " + task);

        modelo.put("task", task);

        return "editTask";
    }

    /*
    Metodo editar
     */
    @PostMapping("/task/edit")
    public String editTask(@ModelAttribute("takForm") Task task){

        logger.info("Tarea a editar: " + task);
        taskService.saveTask(task);

        return "taskPage";
    }

    @GetMapping("/task/delete")
    public String deleteTask(@PathVariable(value = "idTask") Task task){

        taskService.deleteTask(task);

        return "taskPage";
    }
}
