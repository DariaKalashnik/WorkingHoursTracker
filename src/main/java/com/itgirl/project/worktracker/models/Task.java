package com.itgirl.project.worktracker.models;

import java.util.Date;
import java.util.Objects;

public class Task {

    private long id;
    private String name;
    private String description;
    private Date deadline;
    private int expectedWorkingHours;

    public Task() {
    }

    public Task(int id, String name, String description, Date deadline, int expectedWorkingHours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.expectedWorkingHours = expectedWorkingHours;
    }


    // Constructor for testing
    public Task(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getExpectedWorkingHours() {
        return expectedWorkingHours;
    }

    public void setExpectedWorkingHours(int expectedWorkingHours) {
        this.expectedWorkingHours = expectedWorkingHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", expectedWorkingHours=" + expectedWorkingHours +
                '}';
    }
}
