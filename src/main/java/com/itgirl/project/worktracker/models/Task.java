package com.itgirl.project.worktracker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

// TODO 1: modify length and nullability later if needed

@Entity
@Table(name = "t_task")
@Data
@EqualsAndHashCode(of = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Temporary field for testing purposes
    private String name;

    @ManyToOne
    private Project project;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    // TODO 2: automatically stop at 10pm if user forgets

    // TODO 3: start only if user connected to specific network

    @Column(name = "starttime")
    private long starttime;

    @Column(name = "stoptime")
    private long stoptime;

    @Column(name = "totaltime")
    private long totaltime;

    @Column(name = "date")
    private Date date;

    // Temporary constructor for testing
    public Task() {
    }

    // Temporary constructor for testing
    public Task(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
