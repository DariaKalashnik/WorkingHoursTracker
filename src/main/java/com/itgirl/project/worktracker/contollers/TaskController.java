package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.services.DummyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done
@RestController
public class TaskController {

    @Autowired
    public DummyTaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTask(id);
    }

    @DeleteMapping("/tasks/{id}")
    public void removeTask(@PathVariable int id) {
        Task task = taskService.getTask(id);
        taskService.removeTask(task);
    }

    @PostMapping("/tasks")
    public void addNewTask(@RequestBody Task task) {
        if (!taskService.addTask(task)) {
            throw new ConflictException();
        }

    }

    @PutMapping("/tasks")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }


    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "The task with the same id already exists")
    public class ConflictException extends RuntimeException {

    }
}
