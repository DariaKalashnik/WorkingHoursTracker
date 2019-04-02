package com.itgirl.project.worktracker.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

// TODO 1: modify length and nullability later if needed
@Entity
@Table(name = "t_project")
@Data
@EqualsAndHashCode(of = "id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "deadline")
    private Date deadline;
}
