package com.itgirl.project.worktracker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "t_task")
@Data
@EqualsAndHashCode(of = "id")
public class Task {

    // TODO setting the relationships

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    // Temporary field for testing purposes
    private String name;

    private Project project;
    private String description;

    //TODO: main timer (timer will go on like a clock)
    private Time currentTime;

    private Time totalTime;
    private Date date;

    public Task() {
    }

    // Temporary constructor for testing
    public Task(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
