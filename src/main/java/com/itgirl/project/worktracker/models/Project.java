package com.itgirl.project.worktracker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_project")
@Data
@EqualsAndHashCode(of = "id")
public class Project {

    // TODO setting the relationships

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private Date deadline;

    @ManyToMany
    private List<User> workers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<User> getWorkers() {
        return workers;
    }

    public void setWorkers(List<User> workers) {
        this.workers = workers;
    }
}
