package com.itgirl.project.worktracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itgirl.project.worktracker.models.enums.UserRole;
import com.itgirl.project.worktracker.models.enums.WorkerType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

/*
 Class that stores login credentials (email and password).
 User won't have a registration page, each worker can be register only on admin level
 and here they will only login.
*/

// TODO 1: modify length and nullability later if needed
@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "t_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString(exclude = {"password", "projects"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "username", length = 100, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "password", length = 100)
    @Size(min = 8, max = 30)
    private String password;

  /*  // TODO 2: Type can be changed later
    @Enumerated(EnumType.STRING)
    @Column(name = "worker_type")
    private WorkerType workerType;

    // TODO 3: Type can be changed later
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;*/

    @Column(name = "non_expired")
    private boolean accountNonExpired = true;

    @Column(name = "non_locked")
    private boolean accountNonLocked = true;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired = true;

    @Column(name = "firstname", length = 100)
    private String firstName;

    @Column(name = "lastname", length = 100)
    private String lastName;

    @Column(name = "birthdate", length = 100)
    private Date birthDate;

    @Column(name = "country", length = 100)
    private String county;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "zip", length = 100)
    private String zip;



    // https://www.baeldung.com/hibernate-many-to-many

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Project",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id", referencedColumnName = "id") }
    )
    Set<Project> projects = new HashSet<>();

    public void addProject(Project project){
        if (!projects.contains(project)){
            projects.add(project);

        }
    }
}
