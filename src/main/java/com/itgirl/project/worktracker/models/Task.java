package com.itgirl.project.worktracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

// TODO 1: modify length and nullability later if needed

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "t_task")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 200)
    private String name;

    @ManyToOne
    private Project project;

    @Column(name = "description", length = 200)
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
}
