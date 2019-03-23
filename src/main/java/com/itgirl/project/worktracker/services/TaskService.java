package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Task;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class TaskService {

    // Temporary array for testing
    public List<Task> tasks = new ArrayList<>();

    // will run after constructor
    @PostConstruct
    private void generateTasks(){
        for (int i = 0; i < 100; i++){
            tasks.add(new Task(i, "Task " + i));
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index){
        Task searchedTask = tasks.get(index);
        return searchedTask;
    }

    public boolean addTask(Task task){
        if (tasks.contains(task)){
            System.out.println("409 Conflict!");
            return false;
        }

        tasks.add(task);
        return true;
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public void updateTask(Task updatedTask){
        int i = tasks.indexOf(updatedTask);
        Task oldTask = tasks.get(i);

        tasks.remove(oldTask);
        tasks.add(updatedTask);

        System.out.println(oldTask);
        System.out.println(updatedTask);

    }
}
