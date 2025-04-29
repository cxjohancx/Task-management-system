package Kase.TaskManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// User model
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="id_user")
    private Integer idUser;

    @Column(name="name_user")
    private String nameUser;

    @Column(name="lastname_user")
    private String lastnameUser;

    @Column(name="mail")
    private String emailUser;

}
