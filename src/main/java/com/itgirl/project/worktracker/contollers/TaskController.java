package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done
@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.getTasks();

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Task task = taskService.getTask(id);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        if (!taskService.saveTask(task)) {
            throw new ConflictException();
        }

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {

        Task isExists = taskService.getTask(id);
        if (isExists == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (task == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        taskService.saveTask(task);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> removeTask(@PathVariable Long id) {
        Task task = taskService.getTask(id);

        taskService.removeTask(task);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "The task with the same id already exists")
    public class ConflictException extends RuntimeException {

    }
}
