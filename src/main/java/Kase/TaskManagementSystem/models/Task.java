package Kase.TaskManagementSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDate;

// Task Model
@Entity
@Data // Setters and Getters
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_task")
    private Integer idTask;

    @Column(name="title")
    private String titleTask;

    @Column(name="description_task")
    private String descriptionTask;

    @Column(name="date_create")
    private LocalDate dateCreatedTask;

    @Column(name="date_end")
    private LocalDate dateEndTask;

    @Column(name="priority")
    private String priorityTask;

    @Column(name="state")
    private String stateTask;

    @ManyToOne
    @JoinColumn(name = "idUser")
    @Column(name="user_asigned")
    private Integer userAsignedTask;
}
