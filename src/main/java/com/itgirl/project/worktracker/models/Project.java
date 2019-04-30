package com.itgirl.project.worktracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// TODO 1: modify length and nullability later if needed
@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "t_project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "deadline")
    private Date deadline;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
//    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }
}
